package com.wine.to.up.catalog.service.repository.pages;

import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;

public class WinePositionPageRequest implements Pageable {
    @Override
    public PageFormat getPageFormat(int pageIndex) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public Printable getPrintable(int pageIndex) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public int getNumberOfPages() {
        return 0;
    }
}
