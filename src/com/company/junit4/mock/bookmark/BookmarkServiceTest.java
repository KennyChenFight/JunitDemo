package com.company.junit4.mock.bookmark;

import org.junit.Test;
import static org.junit.Assert.*;

public class BookmarkServiceTest {

    @Test
    public void testAdd() {
        BookmarkDao dao = new MockDao();
        Bookmark bookmark1 =
                new Bookmark("testURL1", "testTitle1", "testCategory1");
        Bookmark bookmark2 =
                new Bookmark("testURL2", "testTitle2", "testCategory2");
        dao.add(bookmark1);

        BookmarkService service = new BookmarkService(dao);
        service.add(bookmark1);

        assertEquals(1, dao.get().size());

        service.add(bookmark2);
        assertEquals(2, dao.get().size());

        assertEquals(bookmark2, dao.get().get(1));
    }
}
