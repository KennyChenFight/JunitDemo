package com.company.junit4.easymock.bookmark;

import java.util.List;

public interface BookmarkDao {

    public void add(Bookmark bookmark);

    public void delete(Bookmark bookmark);

    public List<Bookmark> get();
}
