insert into author(id, first_name, last_name) values
 (1, 'author1', 'last1'),
 (2, 'author2', 'last2'),
 (3, 'author3', 'last3');

insert into book(id, title, isbn, page_count, author_id) values
(1, 'book1', 'isbn00001', 100, 1),
(2, 'book2', 'isbn00002', 100, 1),
(3, 'book3', 'isbn00003', 100, 1),
(4, 'book4', 'isbn00004', 100, 2),
(5, 'book5', 'isbn00005', 100, 2),
(6, 'book6', 'isbn00006', 100, 3),
(7, 'book7', 'isbn00007', 100, 3);
