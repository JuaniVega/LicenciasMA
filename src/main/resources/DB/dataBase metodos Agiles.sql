-- Database generated with pgModeler (PostgreSQL Database Modeler).
-- pgModeler version: 0.9.4
-- PostgreSQL version: 13.0
-- Project Site: pgmodeler.io
-- Model Author: ---

-- Database creation must be performed outside a multi lined SQL file. 
-- These commands were put in this file only as a convenience.
-- 
-- object: new_database | type: DATABASE --
-- DROP DATABASE IF EXISTS new_database;
CREATE DATABASE new_database;
-- ddl-end --


-- object: public.persona | type: TABLE --
-- DROP TABLE IF EXISTS public.persona CASCADE;
CREATE TABLE public.persona (
	id serial NOT NULL,
	"tipoDoc" integer,
	dni integer NOT NULL,
	nombre varchar(50) NOT NULL,
	apellido varchar(50) NOT NULL,
	"fechaNac" date NOT NULL,
	"fechaUltModi" timestamp,
	usuario varchar(50),
	CONSTRAINT persona_pk PRIMARY KEY (id),
	CONSTRAINT dni_uq UNIQUE (dni)
);
-- ddl-end --
ALTER TABLE public.persona OWNER TO postgres;
-- ddl-end --

-- object: public."tipoLicencia" | type: TABLE --
-- DROP TABLE IF EXISTS public."tipoLicencia" CASCADE;
CREATE TABLE public."tipoLicencia" (
	id serial NOT NULL,
	clase varchar(1),
	descripcion varchar(255),
	"fechaUltModi" timestamp,
	usuario varchar(50),
	CONSTRAINT "tipoLicencia_pk" PRIMARY KEY (id),
	CONSTRAINT clase_uq UNIQUE (clase)
);
-- ddl-end --
ALTER TABLE public."tipoLicencia" OWNER TO postgres;
-- ddl-end --

-- object: public.administrativo | type: TABLE --
-- DROP TABLE IF EXISTS public.administrativo CASCADE;
CREATE TABLE public.administrativo (
	id serial NOT NULL,
	dni integer,
	email varchar(50) NOT NULL,
	pass varchar(50) NOT NULL,
	"fechaUltModi" timestamp,
	usuario varchar(50),
	CONSTRAINT administrativo_pk PRIMARY KEY (id)
);
-- ddl-end --
ALTER TABLE public.administrativo OWNER TO postgres;
-- ddl-end --

-- object: public.conductor | type: TABLE --
-- DROP TABLE IF EXISTS public.conductor CASCADE;
CREATE TABLE public.conductor (
	id serial NOT NULL,
	dni integer,
	direccion varchar(50),
	"grupoSanguineo" integer,
	"donaOrganos" boolean,
	"fechaUltModi" timestamp,
	usuario varchar(50),
	CONSTRAINT conductor_pk PRIMARY KEY (id)
);
-- ddl-end --
ALTER TABLE public.conductor OWNER TO postgres;
-- ddl-end --

-- object: public."tipoGrupSanguineo" | type: TABLE --
-- DROP TABLE IF EXISTS public."tipoGrupSanguineo" CASCADE;
CREATE TABLE public."tipoGrupSanguineo" (
	id serial NOT NULL,
	"tipoGrupoSanguineo" varchar(3),
	"fechaUltModi" timestamp,
	usuario varchar(50),
	CONSTRAINT "grupoSanguineo_pk" PRIMARY KEY (id)
);
-- ddl-end --
ALTER TABLE public."tipoGrupSanguineo" OWNER TO postgres;
-- ddl-end --

-- object: public."tipoDocumento" | type: TABLE --
-- DROP TABLE IF EXISTS public."tipoDocumento" CASCADE;
CREATE TABLE public."tipoDocumento" (
	id serial NOT NULL,
	"tipoDocumento" varchar(10),
	"fechaUltModi" timestamp,
	usuario varchar(50),
	CONSTRAINT "tipoDocumento_pk" PRIMARY KEY (id)
);
-- ddl-end --
ALTER TABLE public."tipoDocumento" OWNER TO postgres;
-- ddl-end --

-- object: public.licencia | type: TABLE --
-- DROP TABLE IF EXISTS public.licencia CASCADE;
CREATE TABLE public.licencia (
	id serial NOT NULL,
	"idPersona" integer,
	"idTipoLicencia" integer,
	costo integer,
	"fechaEmision" date,
	"fechaVigencia" date,
	"esCopia" boolean,
	"estadoLicencia" boolean,
	"fechaUltModi" timestamp,
	usuario varchar(50),
	CONSTRAINT carnet_pk PRIMARY KEY (id)
);
-- ddl-end --
COMMENT ON COLUMN public.licencia."estadoLicencia" IS E'Si es true, esta vigente, en caso de ser falso, no es vigente';
-- ddl-end --
ALTER TABLE public.licencia OWNER TO postgres;
-- ddl-end --

-- object: "tipoDoc_fk" | type: CONSTRAINT --
-- ALTER TABLE public.persona DROP CONSTRAINT IF EXISTS "tipoDoc_fk" CASCADE;
ALTER TABLE public.persona ADD CONSTRAINT "tipoDoc_fk" FOREIGN KEY ("tipoDoc")
REFERENCES public."tipoDocumento" (id) MATCH SIMPLE
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: persona_fk | type: CONSTRAINT --
-- ALTER TABLE public.administrativo DROP CONSTRAINT IF EXISTS persona_fk CASCADE;
ALTER TABLE public.administrativo ADD CONSTRAINT persona_fk FOREIGN KEY (dni)
REFERENCES public.persona (dni) MATCH SIMPLE
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: persona_fk | type: CONSTRAINT --
-- ALTER TABLE public.conductor DROP CONSTRAINT IF EXISTS persona_fk CASCADE;
ALTER TABLE public.conductor ADD CONSTRAINT persona_fk FOREIGN KEY (dni)
REFERENCES public.persona (dni) MATCH SIMPLE
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: "grupoSanguineo_fk" | type: CONSTRAINT --
-- ALTER TABLE public.conductor DROP CONSTRAINT IF EXISTS "grupoSanguineo_fk" CASCADE;
ALTER TABLE public.conductor ADD CONSTRAINT "grupoSanguineo_fk" FOREIGN KEY ("grupoSanguineo")
REFERENCES public."tipoGrupSanguineo" (id) MATCH SIMPLE
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: "idPersona_fk" | type: CONSTRAINT --
-- ALTER TABLE public.licencia DROP CONSTRAINT IF EXISTS "idPersona_fk" CASCADE;
ALTER TABLE public.licencia ADD CONSTRAINT "idPersona_fk" FOREIGN KEY ("idPersona")
REFERENCES public.persona (dni) MATCH SIMPLE
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --

-- object: "id_tipoLicencia" | type: CONSTRAINT --
-- ALTER TABLE public.licencia DROP CONSTRAINT IF EXISTS "id_tipoLicencia" CASCADE;
ALTER TABLE public.licencia ADD CONSTRAINT "id_tipoLicencia" FOREIGN KEY ("idTipoLicencia")
REFERENCES public."tipoLicencia" (id) MATCH SIMPLE
ON DELETE NO ACTION ON UPDATE NO ACTION;
-- ddl-end --


