package edu.poly.shop.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import edu.poly.shop.domain.Category;
import edu.poly.shop.repository.CatetoryRepository;
import edu.poly.shop.service.CategoryService;
//dalegate để sinh thêm phương thức
// pull up để chuyển qua interface

@Service
public class CategoryServiceImpl implements CategoryService {
	CatetoryRepository catetoryRepository;

	public CategoryServiceImpl(CatetoryRepository catetoryRepository) {

		this.catetoryRepository = catetoryRepository;
	}

	
	

	@Override
	public <S extends Category> S save(S entity) {
		return catetoryRepository.save(entity);
	}

	@Override
	public <S extends Category> Optional<S> findOne(Example<S> example) {
		return catetoryRepository.findOne(example);
	}

	@Override
	public List<Category> findAll() {
		return catetoryRepository.findAll();
	}

	@Override
	public List<Category> findByNameContaining(String name) {
		return catetoryRepository.findByNameContaining(name);
	}


	@Override
	public Page<Category> findByNameContaining(String name, Pageable pageable) {
		return catetoryRepository.findByNameContainingIgnoreCase(name, pageable);
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return catetoryRepository.findAll(pageable);
	}

	@Override
	public List<Category> findAll(Sort sort) {
		return catetoryRepository.findAll(sort);
	}

	@Override
	public List<Category> findAllById(Iterable<Long> ids) {
		return catetoryRepository.findAllById(ids);
	}

	@Override
	public Optional<Category> findById(Long id) {
		return catetoryRepository.findById(id);
	}

	@Override
	public <S extends Category> List<S> saveAll(Iterable<S> entities) {
		return catetoryRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		catetoryRepository.flush();
	}

	@Override
	public <S extends Category> S saveAndFlush(S entity) {
		return catetoryRepository.saveAndFlush(entity);
	}

	@Override
	public boolean existsById(Long id) {
		return catetoryRepository.existsById(id);
	}

	@Override
	public <S extends Category> List<S> saveAllAndFlush(Iterable<S> entities) {
		return catetoryRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Category> Page<S> findAll(Example<S> example, Pageable pageable) {
		return catetoryRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Category> entities) {
		catetoryRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Category> long count(Example<S> example) {
		return catetoryRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Category> entities) {
		catetoryRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return catetoryRepository.count();
	}

	@Override
	public <S extends Category> boolean exists(Example<S> example) {
		return catetoryRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		catetoryRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		catetoryRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Category entity) {
		catetoryRepository.delete(entity);
	}

	@Override
	public <S extends Category, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return catetoryRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		catetoryRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		catetoryRepository.deleteAllInBatch();
	}

	@Override
	public Category getOne(Long id) {
		return catetoryRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Category> entities) {
		catetoryRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		catetoryRepository.deleteAll();
	}

	@Override
	public Category getById(Long id) {
		return catetoryRepository.getById(id);
	}

	@Override
	public <S extends Category> List<S> findAll(Example<S> example) {
		return catetoryRepository.findAll(example);
	}

	@Override
	public <S extends Category> List<S> findAll(Example<S> example, Sort sort) {
		return catetoryRepository.findAll(example, sort);
	}

	
	
	

}
