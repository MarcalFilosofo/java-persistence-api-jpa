package infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Entidade;

import java.util.*;

public class DAO<E extends Entidade> {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;
	
	static {
		try {
			emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		} catch (Exception e) {
			// log4j
		}
	}
	
	public DAO() {
		this(null);
	}
	
	public DAO(Class<E> classe) {
		this.em = emf.createEntityManager();
		this.classe = classe;
	}
	
	public DAO<E> abrirT(){
		em.getTransaction().begin();
		return this;
	}

	public DAO<E> fecharT(){
		em.getTransaction().commit();
		return this;
	}

	public DAO<E> incluir(E entidade) {
		em.persist(entidade);
		return this;
	}

	public DAO<E> atualizar(E entidade) {
		em.merge(entidade);
		return this;
	}

	public DAO<E> incluirAtomico(E entidade) {
		return this.abrirT().incluir(entidade).fecharT();
	}

	public E obterPorId(Object id){
		return em.find(classe, id);
	}

	public List<E> obterTodos(){
		TypedQuery<E> query = em.createQuery("select e from " + classe.getSimpleName() + " e", classe);
		return query.getResultList();
	}

	public List<E> obterTodos (int quantidade, int deslocamento){
		if(this.classe == null){
			throw new RuntimeException("Classe não definida");
		}

		String jpql = "select e from " + this.classe.getSimpleName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, this.classe);
		query.setMaxResults(quantidade);
		query.setFirstResult(deslocamento);
		return query.getResultList();
	}

	public List<E> consultar(String nomeConsutla, Object... params){
		TypedQuery<E> query = em.createNamedQuery(nomeConsutla, classe);
		for(int i = 0; i < params.length; i += 2){
			query.setParameter(params[i].toString(), params[i + 1]);
		}

		return query.getResultList();
	}

	public E consultarUm(String nomeConsutla, Object... params){
		List<E> lista = consultar(nomeConsutla, params);

		if(lista.size() == 0){
			return null;
		}

		return lista.get(0);
	}

	public void fechar() {
		em.close();
	}
}
