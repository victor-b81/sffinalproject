toc.dat                                                                                             0000600 0004000 0002000 00000004132 14433765722 0014454 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP                           {         	   atmapi_db    15.3    15.3 	    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false         �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false         �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false         �           1262    16422 	   atmapi_db    DATABASE     }   CREATE DATABASE atmapi_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';
    DROP DATABASE atmapi_db;
                postgres    false         �            1259    24895    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false         �            1259    24896    table_money    TABLE     p   CREATE TABLE public.table_money (
    id bigint NOT NULL,
    user_balance numeric(19,2),
    user_id bigint
);
    DROP TABLE public.table_money;
       public         heap    postgres    false         �          0    24896    table_money 
   TABLE DATA           @   COPY public.table_money (id, user_balance, user_id) FROM stdin;
    public          postgres    false    215       3318.dat �           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);
          public          postgres    false    214         f           2606    24900    table_money table_money_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.table_money
    ADD CONSTRAINT table_money_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.table_money DROP CONSTRAINT table_money_pkey;
       public            postgres    false    215                                                                                                                                                                                                                                                                                                                                                                                                                                              3318.dat                                                                                            0000600 0004000 0002000 00000000041 14433765722 0014260 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	10.00	1
2	7.00	2
3	0.00	3
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               restore.sql                                                                                         0000600 0004000 0002000 00000004574 14433765722 0015413 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 15.3
-- Dumped by pg_dump version 15.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE atmapi_db;
--
-- Name: atmapi_db; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE atmapi_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';


ALTER DATABASE atmapi_db OWNER TO postgres;

\connect atmapi_db

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: table_money; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.table_money (
    id bigint NOT NULL,
    user_balance numeric(19,2),
    user_id bigint
);


ALTER TABLE public.table_money OWNER TO postgres;

--
-- Data for Name: table_money; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.table_money (id, user_balance, user_id) FROM stdin;
\.
COPY public.table_money (id, user_balance, user_id) FROM '$$PATH$$/3318.dat';

--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);


--
-- Name: table_money table_money_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.table_money
    ADD CONSTRAINT table_money_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    