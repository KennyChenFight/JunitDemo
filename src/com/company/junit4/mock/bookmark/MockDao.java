package com.company.junit4.mock.bookmark;

import java.util.ArrayList;
import java.util.List;

public class MockDao implements BookmarkDao {

    private List<Bookmark> bookmarks = new ArrayList<>();

    @Override
    public void add(Bookmark bookmark) {
        bookmarks.add(bookmark);
    }

    @Override
    public void delete(Bookmark bookmark) {
        bookmarks.remove(bookmark);
    }

    @Override
    public List<Bookmark> get() {
        return bookmarks;
    }
}
