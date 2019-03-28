package com.company.junit4.mock.bookmark;

public class BookmarkService {

    private BookmarkDao dao;

    public BookmarkService(BookmarkDao dao) {
        this.dao = dao;
    }

    public void add(Bookmark bookmark) {
        if (!dao.get().contains(bookmark)) {
            dao.add(bookmark);
        }
    }
}
