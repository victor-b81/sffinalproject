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
-- Name: table_history_operation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.table_history_operation (
    id bigint NOT NULL,
    date_time integer,
    operation_id integer,
    user_balance numeric(19,2),
    user_id bigint
);


ALTER TABLE public.table_history_operation OWNER TO postgres;

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
-- Data for Name: table_history_operation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.table_history_operation (id, date_time, operation_id, user_balance, user_id) FROM stdin;
\.


--
-- Data for Name: table_money; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.table_money (id, user_balance, user_id) FROM stdin;
1	10.00	1
2	7.00	2
3	0.00	3
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);


--
-- Name: table_history_operation table_history_operation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.table_history_operation
    ADD CONSTRAINT table_history_operation_pkey PRIMARY KEY (id);


--
-- Name: table_money table_money_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.table_money
    ADD CONSTRAINT table_money_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

