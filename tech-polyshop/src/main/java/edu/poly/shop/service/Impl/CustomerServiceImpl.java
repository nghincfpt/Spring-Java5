package edu.poly.shop.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import edu.poly.shop.domain.Account;
import edu.poly.shop.domain.Customer;
import edu.poly.shop.domain.Customer1;
import edu.poly.shop.model.CustomerDto;
import edu.poly.shop.repository.CustomerRepository;
import edu.poly.shop.service.CustomerService;
import groovyjarjarantlr4.v4.parse.ANTLRParser.option_return;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public <S extends Customer1> S save(S entity) {
		return customerRepository.save(entity);
	}

	@Override
	public <S extends Customer1> Optional<S> findOne(Example<S> example) {
		return customerRepository.findOne(example);
	}

	@Override
	public List<Customer1> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Page<Customer1> findAll(Pageable pageable) {
		return customerRepository.findAll(pageable);
	}

	@Override
	public List<Customer1> findAll(Sort sort) {
		return customerRepository.findAll(sort);
	}

	@Override
	public List<Customer1> findAllById(Iterable<String> ids) {
		return customerRepository.findAllById(ids);
	}

	@Override
	public Optional<Customer1> findById(String id) {
		return customerRepository.findById(id);
	}

	@Override
	public <S extends Customer1> List<S> saveAll(Iterable<S> entities) {
		return customerRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		customerRepository.flush();
	}

	@Override
	public <S extends Customer1> S saveAndFlush(S entity) {
		return customerRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(String id) {
		return customerRepository.existsById(id);
	}

	@Override
	public <S extends Customer1> List<S> saveAllAndFlush(Iterable<S> entities) {
		return customerRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Customer1> Page<S> findAll(Example<S> example, Pageable pageable) {
		return customerRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Customer1> entities) {
		customerRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Customer1> long count(Example<S> example) {
		return customerRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Customer1> entities) {
		customerRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return customerRepository.count();
	}

	@Override
	public <S extends Customer1> boolean exists(Example<S> example) {
		return customerRepository.exists(example);
	}

	@Override
	public void deleteById(String id) {
		customerRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		customerRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Customer1 entity) {
		customerRepository.delete(entity);
	}

	@Override
	public <S extends Customer1, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return customerRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		customerRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		customerRepository.deleteAllInBatch();
	}

	@Override
	public Customer1 getOne(String id) {
		return customerRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Customer1> entities) {
		customerRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		customerRepository.deleteAll();
	}

	@Override
	public Customer1 getById(String id) {
		return customerRepository.getById(id);
	}

	@Override
	public <S extends Customer1> List<S> findAll(Example<S> example) {
		return customerRepository.findAll(example);
	}

	@Override
	public <S extends Customer1> List<S> findAll(Example<S> example, Sort sort) {
		return customerRepository.findAll(example, sort);
	}

	

}
