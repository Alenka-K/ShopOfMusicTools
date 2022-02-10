INSERT INTO LAB2_EK_CATEGORIES (cat_name, cat_discount) VALUES ('Piano', 3);
INSERT INTO LAB2_EK_CATEGORIES (cat_name, cat_discount) VALUES ('Gitar', 10);
INSERT INTO LAB2_EK_CATEGORIES (cat_name, cat_discount) VALUES ('Violin', 2);
INSERT INTO LAB2_EK_CATEGORIES (cat_name, cat_discount) VALUES ('Flute', 5);

INSERT INTO LAB2_EK_PRODUCER (prod_name, prod_country) VALUES ('MAXTONE', 'Chaina');
INSERT INTO LAB2_EK_PRODUCER (prod_name, prod_country) VALUES ('CORT', 'Indonesia');
INSERT INTO LAB2_EK_PRODUCER (prod_name, prod_country) VALUES ('HOHNER', 'Germany');

INSERT INTO LAB2_EK_TOOLS (TOOL_MODEL, TOOL_TITLE, TOOL_PRICE, CAT_ID, PROD_ID) VALUES ('SD-65 TBK SOLO', 'Акустическая гитара', 6750, 2, 2);
INSERT INTO LAB2_EK_TOOLS (TOOL_MODEL, TOOL_TITLE, TOOL_PRICE, CAT_ID, PROD_ID) VALUES ('DGX-660', 'цифровое фортепиано', 26550, 1, 3);
INSERT INTO LAB2_EK_TOOLS (TOOL_MODEL, TOOL_TITLE, TOOL_PRICE, CAT_ID, PROD_ID) VALUES ('TV4/4A LL', 'Скрипка', 1980, 3, 1);

INSERT INTO LAB2_EK_CUSTOMER (cust_name, cust_phone) VALUES ('Oleg', '(066) 557-8361');
INSERT INTO LAB2_EK_CUSTOMER (cust_name, cust_phone) VALUES ('Alena', '(050) 353-4523');
INSERT INTO LAB2_EK_CUSTOMER (cust_name, cust_phone) VALUES ('Alex', '(066) 557 5612');
commit;
