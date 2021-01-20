package com.cembrzynski.clinic.validator;

import com.cembrzynski.clinic.data.entity.Appointment;
import com.cembrzynski.clinic.data.repository.AppointmentRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class AppointmentRepositoryMock implements AppointmentRepository {

    private Appointment data;

    public AppointmentRepositoryMock() {
        //Should be empty
    }

    public AppointmentRepositoryMock(Appointment data) {
        this.data = data;
    }

    @Override
    public List<Appointment> findByDoctorId(Long id) {
        return null;
    }

    @Override
    public Optional<Appointment> findByDate(LocalDateTime date) {
        return Optional.ofNullable(data);
    }

    @Override
    public List<Appointment> findAll() {
        return null;
    }

    @Override
    public List<Appointment> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Appointment> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Appointment> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Appointment entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends Appointment> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Appointment> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Appointment> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Appointment> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Appointment> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Appointment> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Appointment getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Appointment> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Appointment> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Appointment> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Appointment> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Appointment> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Appointment> boolean exists(Example<S> example) {
        return false;
    }

    public void setData(Appointment data) {
        this.data = data;
    }
}
