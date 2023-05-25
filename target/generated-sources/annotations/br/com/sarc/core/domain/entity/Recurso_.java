package br.com.sarc.core.domain.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Recurso.class)
public abstract class Recurso_ {

	public static volatile SingularAttribute<Recurso, String> nome;
	public static volatile SingularAttribute<Recurso, Long> id;
	public static volatile SingularAttribute<Recurso, Status> status;

	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String STATUS = "status";

}

