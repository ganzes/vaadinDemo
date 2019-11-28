package com.vaadindemo.vaadindemo;

import com.kodilla.books.domain.Book;
import com.kodilla.books.domain.BookService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    private BookService bookService = BookService.getInstance();
    private Grid<Book> grid = new Grid<>(Book.class);
    private TextField filter = new TextField();


    public MainView() {
        grid.setColumns("title", "author", "publicationYear", "type");
        add(grid);
        setSizeFull();
        refresh();

        filter.setPlaceholder("Filter by title");
        filter.setClearButtonVisible(true);
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(event -> update());
        add(filter,grid);

    }

    public void refresh(){
        grid.setItems(bookService.getBooks());
    }

    private void update(){
        grid.setItems(bookService.findByTitle(filter.getValue()));
    }
}
