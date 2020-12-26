package com.ppl.pack;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

public class PackageUtil implements INotifyPackageFull {
    private static final byte[] DEFAULT_HEADER = new byte[]{0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};
    private static final int PACK_SIZE = 1024;
    private static final int XY_PACK_SIZE_HEADER = 44;
    private static final int PACK_SIZE_HEADER = 16;
    private static final int PACK_SIZE_WITH_HEADER = PACK_SIZE + PACK_SIZE_HEADER;
    private static final int TIMEOUT_MILLISECONDS = 5000;

    private static int packageID = 0;
    private static Object objectIdLocker = new Object();
    private boolean isTesting = false;

    private static int getPackageID() {
        //一定要加锁,可能会导致2000个组包、收包下有10MS左右的性能损失
        //但是能解决多线程下就算使用volatile也会导致获取到的ID相同,从而造成不同的包ID相同的问题.
        synchronized (objectIdLocker) {
            packageID += 1;
            return packageID;
        }
    }

    public static int getPackageKey(int deviceID, int packageID) {
        return (deviceID << 16) + packageID;
    }

    public static List<byte[]> unpack(byte[] source) {
        if (source == null || source.length == 0) {
            return null;
        } else {
            int ID = getPackageID();
            int allSize = source.length;
            List<byte[]> unpacked = new java.util.ArrayList<byte[]>();
            try {
                int height = allSize >> 10;
                int low = allSize & 0x3FF;
                int count = low > 0 ? height + 1 : height;
                int index = 0;
                if (count == 1) {
                    byte[] header = new byte[PACK_SIZE_HEADER];
                    System.arraycopy(DEFAULT_HEADER, 0, header, 0, PACK_SIZE_HEADER);
                    byte[] id = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(ID).array();
                    byte[] size = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(allSize).array();
                    System.arraycopy(id, 0, header, 0, 4);
                    System.arraycopy(size, 0, header, 12, 4);
                    byte[] peer = new byte[allSize + PACK_SIZE_HEADER];
                    System.arraycopy(header, 0, peer, 0, PACK_SIZE_HEADER);
                    System.arraycopy(source, 0, peer, PACK_SIZE_HEADER, allSize);
                    unpacked.add(peer);
                } else {
                    ByteBuffer stream = ByteBuffer.wrap(source).order(ByteOrder.LITTLE_ENDIAN);
                    while (stream.remaining() > 0) {
                        UnpackHeader header = new UnpackHeader();
                        header.PackageID = ID;
                        header.PackageIndex = index;
                        header.PackageCount = count;
                        long remainder = stream.remaining();
                        byte[] peer;
                        if (remainder > PACK_SIZE) {
                            peer = new byte[PACK_SIZE_WITH_HEADER];
                            stream.get(peer, PACK_SIZE_HEADER, PACK_SIZE);
                            header.SubSize = PACK_SIZE;
                        } else {
                            peer = new byte[(int) remainder + PACK_SIZE_HEADER];
                            stream.get(peer, PACK_SIZE_HEADER, (int) remainder);
                            header.SubSize = (int) remainder;
                        }
                        byte[] h_bytes = header.toBytes();
                        System.arraycopy(h_bytes, 0, peer, 0, h_bytes.length);
                        unpacked.add(peer);
                        index++;
                    }
                }

            } catch (Exception es) {
                es.printStackTrace();
            }
            return unpacked;
        }

    }

    private ConcurrentHashMap<Integer, Package> packagesCache;
    private ConcurrentLinkedDeque<Integer> listExpiredPackageIDs;
    private ConcurrentLinkedDeque<Integer> listFullPackageIDs;
    private volatile boolean isRunning;

    private IReceivedFullBuffer onReceivedFullBufferHandler;

    public void setOnReceivedFullBufferHandler(IReceivedFullBuffer handler) {
        if (handler != null) {
            onReceivedFullBufferHandler = handler;
        }
    }

    @Override
    public void NotifyPackageFull(int keyValue) {
        if (listFullPackageIDs != null) {
            listFullPackageIDs.add(keyValue);
        }
    }

    public class Package {
        public INotifyPackageFull NotifyPackageFullHandler;

        public long firstTimeReceived;
        private int Key;
        private int receivedIndex;
        private int targetIndex;
        private int bagType;
        private String srcIpPort;
        private int FullSize;

        public Package(int key, int type, String ipPort) {
            Key = key;
            this.bagType = type;
            this.srcIpPort = ipPort;
            firstTimeReceived = System.currentTimeMillis();
        }

        public final void setReceivedIndex(int index) {
            receivedIndex += index;
            if (targetIndex == receivedIndex) {
                if (NotifyPackageFullHandler != null) {
                    NotifyPackageFullHandler.NotifyPackageFull(Key);
                }
            }
        }

        public final void setPackageCount(int count) {
            setPackageList(new byte[count][]);
            targetIndex = ((count - 1) * count) / 2;
        }

        public final void addSizeCount(int size) {
            FullSize += size;
        }

        public final boolean getIsExpired() {
            return (System.currentTimeMillis() - firstTimeReceived) > TIMEOUT_MILLISECONDS;
        }

        private byte[][] privatePackageList;

        public final byte[][] getPackageList() {
            return privatePackageList;
        }

        public final void setPackageList(byte[][] value) {
            privatePackageList = value;
        }

        public final FullPackage getFullPackage() {
            if (!getIsExpired()) {
                byte[] data = new byte[FullSize];
                int subIndex = 0;
                for (int i = 0; i < getPackageList().length; i++) {
                    byte[] sub = getPackageList()[i];
                    if (sub == null) {
                        System.out.println("Sub Package is null:" + i);
                        return null;
                    } else {
                        System.arraycopy(sub, 0, data, subIndex, sub.length);
                        subIndex += sub.length;
                    }
                }
                FullPackage fullPackage = new FullPackage(bagType, data.length, srcIpPort, data);
                return fullPackage;
            } else {
                return null;
            }
        }
    }

    public PackageUtil() {
        packagesCache = new ConcurrentHashMap<Integer, Package>();
        listFullPackageIDs = new ConcurrentLinkedDeque<Integer>();
        listExpiredPackageIDs = new ConcurrentLinkedDeque<Integer>();
        isRunning = true;
        startPacking();
    }

    public final void pack(int deviceID, int bagType, String srcIpPort, byte[] source) {
        if (isRunning == false) {
            return;
        }
        byte[] buffer;
        if (isTesting) {
            buffer = source;
        } else {
            buffer = Arrays.copyOfRange(source, XY_PACK_SIZE_HEADER, source.length);
        }
        if (buffer == null || buffer.length <= PACK_SIZE_HEADER) {
            System.out.println("PackageUtil:buffer too small");
            return;
        } else {
            UnpackHeader header = UnpackHeader.getUnpackHeader(buffer, 0);
            if (buffer.length == header.SubSize + PACK_SIZE_HEADER) {
                int key = getPackageKey(deviceID, header.PackageID);
                Package packet = null;
                if (!packagesCache.containsKey(key)) {
                    packet = new Package(key, bagType, srcIpPort);
                    packet.NotifyPackageFullHandler = this;
                    packet.setPackageCount(header.PackageCount);
                    packet.setReceivedIndex(header.PackageIndex);
                    packet.addSizeCount(header.SubSize);
                    byte[] data = new byte[header.SubSize];
                    System.arraycopy(buffer, PACK_SIZE_HEADER, data, 0, header.SubSize);
                    packet.getPackageList()[header.PackageIndex] = data;
                    packagesCache.put(key, packet);
                } else {
                    Package aPackage = packagesCache.get(key);
                    if (aPackage != null) {
                        aPackage.setReceivedIndex(header.PackageIndex);
                        aPackage.addSizeCount(header.SubSize);
                        byte[] data = new byte[header.SubSize];
                        System.arraycopy(buffer, PACK_SIZE_HEADER, data, 0, header.SubSize);
                        aPackage.getPackageList()[header.PackageIndex] = data;
                    }
                }
            } else {
                System.out.println("PackageUtil:bad buffer");
            }
        }
    }

    private void startPacking() {
        /*final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 5, 4, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(50));*/
        final ExecutorService fixedExecutorService = Executors.newFixedThreadPool(2);
        fixedExecutorService.submit(() -> {
            while (isRunning) {
                int id = 0;
                short times = 0;
                while (listFullPackageIDs.size() > 0) {
                    id = listFullPackageIDs.pop();
                    Package packet = packagesCache.remove(id);
                    if (packet != null && !packet.getIsExpired()) {
                        FullPackage fullPackage = packet.getFullPackage();
                        if (onReceivedFullBufferHandler != null) {
                            onReceivedFullBufferHandler.ReceivedFullBuffer(fullPackage);
                        }
                    } else {
                        System.out.println("Package Timeout");
                    }
                }
                if (times == 200) {
                    if (packagesCache != null && packagesCache.size() > 0) {
                        Iterator<Integer> iterator = packagesCache.keySet().iterator();
                        while (iterator.hasNext()) {
                            int key = iterator.next();
                            Package packet = packagesCache.get(key);
                            if (packet.getIsExpired()) {
                                listExpiredPackageIDs.add(key);
                            }
                        }

                    }
                    times = -1;
                }
                times++;
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        fixedExecutorService.submit(() -> {
            while (isRunning) {
                int id = 0;
                while (listExpiredPackageIDs.size() > 0) {
                    id = listExpiredPackageIDs.pop();
                    Package packet = packagesCache.get(id);
                    if (packet != null) {
                        packagesCache.remove(id);
                        System.out.println("删除超时的不完整包" + packet.toString());
                    }
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}