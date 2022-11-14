package edu.poly.shop.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import edu.poly.shop.domain.Customer1;

public interface CustomerService {

	<S extends Customer1> List<S> findAll(Example<S> example, Sort sort);

	<S extends Customer1> List<S> findAll(Example<S> example);

	Customer1 getById(String id);

	void deleteAll();

	void deleteAll(Iterable<? extends Customer1> entities);

	Customer1 getOne(String id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends String> ids);

	<S extends Customer1, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Customer1 entity);

	void deleteAllByIdInBatch(Iterable<String> ids);

	void deleteById(String id);

	<S extends Customer1> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Customer1> entities);

	<S extends Customer1> long count(Example<S> example);

	void deleteInBatch(Iterable<Customer1> entities);

	<S extends Customer1> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Customer1> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(String id);

	<S extends Customer1> S saveAndFlush(S entity);

	void flush();

	<S extends Customer1> List<S> saveAll(Iterable<S> entities);

	Optional<Customer1> findById(String id);

	List<Customer1> findAllById(Iterable<String> ids);

	List<Customer1> findAll(Sort sort);

	Page<Customer1> findAll(Pageable pageable);

	List<Customer1> findAll();

	<S extends Customer1> Optional<S> findOne(Example<S> example);

	<S extends Customer1> S save(S entity);

	
}