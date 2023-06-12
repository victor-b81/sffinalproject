--
-- PostgreSQL database dump
--

-- Dumped from database version 15.3
-- Dumped by pg_dump version 15.3

-- Started on 2023-06-13 02:26:36

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
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: pg_database_owner
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO pg_database_owner;

--
-- TOC entry 3335 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: pg_database_owner
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 214 (class 1259 OID 25055)
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
-- TOC entry 218 (class 1259 OID 39500)
-- Name: table_history_operation; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.table_history_operation (
    id integer NOT NULL,
    amount_transaction character varying(255),
    comment_transaction character varying(255),
    operation_id character varying(255),
    date date,
    "timestamp" timestamp without time zone,
    user_id character varying(255)
);


ALTER TABLE public.table_history_operation OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 39499)
-- Name: table_history_operation_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.table_history_operation_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.table_history_operation_id_seq OWNER TO postgres;

--
-- TOC entry 3336 (class 0 OID 0)
-- Dependencies: 217
-- Name: table_history_operation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.table_history_operation_id_seq OWNED BY public.table_history_operation.id;


--
-- TOC entry 216 (class 1259 OID 39491)
-- Name: table_money; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.table_money (
    id integer NOT NULL,
    user_balance character varying(255),
    user_id character varying(255)
);


ALTER TABLE public.table_money OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 39490)
-- Name: table_money_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.table_money_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.table_money_id_seq OWNER TO postgres;

--
-- TOC entry 3337 (class 0 OID 0)
-- Dependencies: 215
-- Name: table_money_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.table_money_id_seq OWNED BY public.table_money.id;


--
-- TOC entry 3180 (class 2604 OID 39503)
-- Name: table_history_operation id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.table_history_operation ALTER COLUMN id SET DEFAULT nextval('public.table_history_operation_id_seq'::regclass);


--
-- TOC entry 3179 (class 2604 OID 39494)
-- Name: table_money id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.table_money ALTER COLUMN id SET DEFAULT nextval('public.table_money_id_seq'::regclass);


--
-- TOC entry 3329 (class 0 OID 39500)
-- Dependencies: 218
-- Data for Name: table_history_operation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.table_history_operation (id, amount_transaction, comment_transaction, operation_id, date, "timestamp", user_id) FROM stdin;
1	50	Client put the money	1	2023-06-13	2023-06-13 01:42:55.186411	1
2	70	Client put the money	1	2023-06-13	2023-06-13 01:42:55.192644	2
\.


--
-- TOC entry 3327 (class 0 OID 39491)
-- Dependencies: 216
-- Data for Name: table_money; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.table_money (id, user_balance, user_id) FROM stdin;
2	1150	1
1	1270	2
\.


--
-- TOC entry 3338 (class 0 OID 0)
-- Dependencies: 214
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);


--
-- TOC entry 3339 (class 0 OID 0)
-- Dependencies: 217
-- Name: table_history_operation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.table_history_operation_id_seq', 2, true);


--
-- TOC entry 3340 (class 0 OID 0)
-- Dependencies: 215
-- Name: table_money_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.table_money_id_seq', 2, true);


--
-- TOC entry 3182 (class 2606 OID 39498)
-- Name: table_money table_money_user_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.table_money
    ADD CONSTRAINT table_money_user_id_key UNIQUE (user_id);


-- Completed on 2023-06-13 02:26:36

--
-- PostgreSQL database dump complete
--

