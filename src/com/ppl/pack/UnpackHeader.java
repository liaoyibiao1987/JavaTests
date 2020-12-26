package com.ppl.pack;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class UnpackHeader {
    private static final int packSize = 16;

    public int PackageID;
    public int PackageIndex;
    public int PackageCount;
    public int SubSize;

    public byte[] toBytes() {
        ByteBuffer allocate = ByteBuffer.allocate(packSize).order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(0, PackageID);
        allocate.putInt(4, PackageIndex);
        allocate.putInt(8, PackageCount);
        allocate.putInt(12, SubSize);
        return allocate.array();
    }

    public static UnpackHeader getUnpackHeader(byte[] source, int index) {
        UnpackHeader retValue = new UnpackHeader();
        ByteBuffer wrap = ByteBuffer.wrap(source, index, packSize).order(ByteOrder.LITTLE_ENDIAN);
        retValue.PackageID = wrap.getInt(0);
        retValue.PackageIndex = wrap.getInt(4);
        retValue.PackageCount = wrap.getInt(8);
        retValue.SubSize = wrap.getInt(12);
        return retValue;
    }

    public UnpackHeader clone() {
        UnpackHeader varCopy = new UnpackHeader();

        varCopy.PackageID = this.PackageID;
        varCopy.PackageIndex = this.PackageIndex;
        varCopy.PackageCount = this.PackageCount;
        varCopy.SubSize = this.SubSize;

        return varCopy;
    }


}
