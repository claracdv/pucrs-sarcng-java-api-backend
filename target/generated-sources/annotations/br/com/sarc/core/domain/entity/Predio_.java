package br.com.sarc.core.domain.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Predio.class)
public abstract class Predio_ {

	public static volatile SingularAttribute<Predio, String> nome;
	public static volatile SingularAttribute<Predio, Long> id;
	public static volatile SingularAttribute<Predio, String> local;
	public static volatile SingularAttribute<Predio, String> descricao;

	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String LOCAL = "local";
	public static final String DESCRICAO = "descricao";

}

