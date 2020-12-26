package com.ppl.pack;

public class FullPackage
{
    public FullPackage(int bagType, int size, String ipPort, byte[] data)
    {
        this.setBagType(bagType);
        this.setPackageSize(size);
        this.setSrcIpPort(ipPort);
        this.setBuffer(data);
    }
    /**
     收到的数据

     */
    private byte[] privateBuffer;
    public final byte[] getBuffer()
    {
        return privateBuffer;
    }
    public final void setBuffer(byte[] value)
    {
        privateBuffer = value;
    }
    /**
     数据大小

     */
    private int privatePackageSize;
    public final int getPackageSize()
    {
        return privatePackageSize;
    }
    public final void setPackageSize(int value)
    {
        privatePackageSize = value;
    }
    /**
     一级命令

     */
    private int privateBagType;
    public final int getBagType()
    {
        return privateBagType;
    }
    public final void setBagType(int value)
    {
        privateBagType = value;
    }
    /**
     来源IP地址

     */
    private String privateSrcIpPort;
    public final String getSrcIpPort()
    {
        return privateSrcIpPort;
    }
    public final void setSrcIpPort(String value)
    {
        privateSrcIpPort = value;
    }

    @Override
    public String toString()
    {
        return String.format(" BagType%1$s , SrcIpPort%2$s , PackageSize%3$s", getBagType(), getSrcIpPort(), getPackageSize());
    }
}
