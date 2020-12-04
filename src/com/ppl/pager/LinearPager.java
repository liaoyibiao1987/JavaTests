package com.ppl.pager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LinearPager<T> {
    private static Logger logger = Logger.getLogger(String.valueOf(LinearPager.class));

    public static void main(String[] args) {
        logger.setLevel(Level.ALL);
        logger.info("AAAA");
    }

    private int mPageSize = 6;
    private int mPagingHeader = 0;
    private int mPagingTail = 0;
    private int mPageIndex = 0;
    private List<T> mDatas;

    public LinearPager(int pageSize) {
        mPageSize = pageSize;
    }

    public void init(List<T> data) {
        if (data == null) {
            mDatas = new ArrayList<>();
        } else {
            mDatas = data;
        }
    }

    public synchronized void update(List<T> data, Comparator<? super T> c) {
        if (data != null && data.size() > 0) {
            for (int i = 0; i < data.size(); i++) {
                final T temp = data.get(i);
                int index = -1;
                if (mDatas.contains(temp)) {
                    index = mDatas.indexOf(temp);
                    if (c.compare(temp, mDatas.get(index)) != 0) {
                        mDatas.set(index, temp);
                    }
                } else {
                    mDatas.add(temp);
                    if (mPagingHeader)
                }
            }
        } else {
            logger.info("AAAA");
        }
    }

    public synchronized List<T> getNextPage() {
        if (mDatas != null && mDatas.size() > 0) {
            final int size = mDatas.size();
            if (mPagingHeader + mPageSize > size) {
                if (mPagingHeader == 0 && mPagingTail == 0) {
                    mPagingTail = size < (mPagingHeader + mPageSize - 1) ? size : mPagingHeader + mPageSize - 1;
                    mPageIndex += 1;
                    return mDatas.subList(mPagingHeader, mPagingTail);//第一次获取
                } else {
                    return null;//最后一页了
                }
            } else {
                mPagingHeader += mPageSize;//头
                mPagingTail = mPagingHeader + mPageSize - 1;//尾
                mPageIndex += 1;
                return mDatas.subList(mPagingHeader, mPagingTail);
            }
        } else {
            return null;
        }
    }

    public synchronized List<T> getPreviousPage() {
        if (mDatas != null && mDatas.size() > 0) {
            final int size = mDatas.size();
            if (mPageIndex > 0) {
            }
        } else {
            return null;
        }
        return null;
    }
}
