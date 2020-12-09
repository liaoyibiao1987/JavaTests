package com.ppl.pager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LinearPager<T> {
    private static Logger logger = Logger.getLogger(String.valueOf(LinearPager.class));

    public static interface DataSourceChangedEventHandle {
        void OnDataChanged(Object o);
    }

    private int mPageSize = 6;
    private int mPageIndex = -1;
    private int mHeader = 0;
    private int mTail = 0;
    private List<T> mDatas;

    private DataSourceChangedEventHandle onDataSourceChangedEventHandler;

    public LinearPager(int pageSize) {
        mPageSize = pageSize;
    }

    public void setOnDataSourceChangedEventHandler(DataSourceChangedEventHandle handler) {
        onDataSourceChangedEventHandler = handler;
    }

    public void init(List<T> data) {
        if (data == null) {
            mDatas = new ArrayList<>();
        } else {
            mDatas = data;
        }
    }

    public synchronized void update(List<T> data, Comparator<? super T> c) {
        if (mDatas == null) {
            init(data);
            if (onDataSourceChangedEventHandler != null) {
                onDataSourceChangedEventHandler.OnDataChanged(getCurrentPage());
            }
        } else {
            if (data != null && data.size() > 0) {
                boolean added = false;
                boolean updated = false;
                List<T> sub;
                for (int i = 0; i < data.size(); i++) {
                    final T temp = data.get(i);
                    int index = mDatas.indexOf(temp);
                    if (index >= 0) {
                        if (c == null) {
                            if (temp instanceof Comparable) {
                                if (((Comparable) temp).compareTo(mDatas.get(index)) != 0) {
                                    mDatas.set(index, temp);
                                    //>使用布尔运算符||,如果第一项为真,则第二项不会被评估.
                                    //>使用按位运算符|两个术语都被评估
                                    //同样…
                                    //>使用布尔运算符&& ;;如果第一项为假,则不会计算第二项
                                    //>使用按位运算符&,计算两个项
                                    updated = updated || (index >= mHeader && index < mTail);
                                }
                            }
                        } else if (c.compare(temp, mDatas.get(index)) != 0) {
                            mDatas.set(index, temp);
                            updated = updated || (index >= mHeader && index < mTail);
                        }
                    } else {
                        added = added || (mTail < mHeader + mPageSize);
                        mDatas.add(temp);
                    }
                }
                if (added) {
                    if (mTail - mHeader < mPageSize) {
                        mTail = mHeader + mPageSize < mDatas.size() ? mHeader + mPageSize : mDatas.size();
                    } else {
                        logger.warning("No need change tail.");
                    }
                    if (onDataSourceChangedEventHandler != null) {
                        sub = mDatas.subList(mHeader, mTail);
                        onDataSourceChangedEventHandler.OnDataChanged(sub);
                    }
                } else {
                    if (updated && onDataSourceChangedEventHandler != null) {
                        sub = mDatas.subList(mHeader, mTail);
                        onDataSourceChangedEventHandler.OnDataChanged(sub);
                    }
                }

            } else {
                logger.warning("Update: data is null");
            }
        }

    }

    public synchronized List<T> getNextPage() {
        if (mDatas != null && mDatas.size() > 0) {
            final int size = mDatas.size();
            if (mTail >= size) {
                return null;//最后一页了
            } else {
                if (mHeader == 0 && mTail == 0) {
                    mPageIndex = 0;
                } else {
                    mPageIndex += 1;
                }
                mHeader = mPageIndex * mPageSize;
                int to = (mPageIndex + 1) * mPageSize;
                mTail = to > size ? size : to;
                return mDatas.subList(mHeader, mTail);
            }
        } else {
            return null;
        }
    }

    public synchronized List<T> getPreviousPage() {
        if (mDatas != null && mDatas.size() > 0) {
            final int size = mDatas.size();
            if (mPageIndex > 0) {
                mPageIndex -= 1;
                mTail = mHeader;
                mHeader = mPageIndex * mPageSize;
                return mDatas.subList(mHeader, mTail);
            } else {
                return null;//第一页了
            }
        } else {
            return null;
        }
    }

    public synchronized List<T> getCurrentPage() {
        if (mDatas != null && mDatas.size() > 0) {
            if (mHeader == mTail && mHeader == 0) {
                mTail = mDatas.size() > mPageSize ? mPageSize : mDatas.size();
            }
            return mDatas.subList(mHeader, mTail);
        } else {
            logger.warning("getCurrentPage: data is null");
            return null;
        }
    }
}
