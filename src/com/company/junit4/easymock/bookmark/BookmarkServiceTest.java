package com.company.junit4.easymock.bookmark;

import static org.easymock.EasyMock.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BookmarkServiceTest {

    private Bookmark bookmark1;
    private Bookmark bookmark2;
    private BookmarkDao dao;
    private BookmarkService service;

    @Before
    public void setUp() {
        bookmark1 = new Bookmark("testURL1", "testTitle1", "testCategory1");
        bookmark2 = new Bookmark("testURL2", "testTitle2", "testCategory2");
        // 動態建立Mock物件
        dao = createMock(BookmarkDao.class);
        service = new BookmarkService(dao);
    }

    @Test
    public void testAddSameBookmark() {
        // 錄製預期被呼叫的方法、設定預期傳回值
        expect(dao.get()).andReturn(Arrays.asList(bookmark1));
        replay(dao);

        service.add(bookmark1);
    }

    @Test
    public void testAddDifferentBookmark() {
        expect(dao.get()).andReturn(Arrays.asList(bookmark1));
        dao.add(bookmark2);
        replay(dao);

        service.add(bookmark2);
    }

    @After
    public void tearDown() {
        // 驗證預期的流程是否完成
        verify(dao);
    }
}
