package com.ipartek.formacion.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.domain.Cursos;
import com.ipartek.formacion.repository.mapper.CursosMapper;

@Repository("DAOCursos")
public class DAOCursosImpl implements DAOCursos {

	private final Log LOG = LogFactory.getLog(getClass());
	private static final String ERROR_INESPERADO = "Excepción inesperada";

	@Autowired()
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Autowired()
	@Override()
	public void setDatasource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);

	}

	private static final String SQL_COGER_TODOS = "SELECT `id`, `NomCurso`, `CodCurso` FROM `curso` ORDER BY `id` DESC LIMIT 1000;";
	private static final String SQL_COGER_ULTIMOS_DIEZ = "SELECT `id`, `NomCurso`, `CodCurso` FROM `curso` ORDER BY `id` DESC LIMIT 10;";
	private static final String SQL_GET_BY_ID = "SELECT `id`, `NomCurso`, `CodCurso` FROM `curso` WHERE `id` = ?;";
	private static final String SQL_INSERTAR = "INSERT INTO `curso` (`NomCurso`, `CodCurso`) VALUES (?, ?);";
	private static final String SQL_ACTUALIZAR = "UPDATE `curso` SET `NomCurso`= ? , `CodCurso`= ? WHERE `id`= ? ;";
	private static final String SQL_ELIMINAR = "DELETE FROM `curso` WHERE `id` = ?;";
	private static final String SQL_FILTRO = "SELECT `id`, `NomCurso`, `CodCurso` FROM `curso` WHERE `NomCurso` LIKE '%' ? '%' ORDER BY `NomCurso` DESC;";

	@Override()
	public List<Cursos> cogerTodos(String filtro) {
		ArrayList<Cursos> listado = new ArrayList<Cursos>();

		try {

			if (filtro == null) {

				this.LOG.trace("Listar todos los cursos");
				listado = (ArrayList<Cursos>) this.jdbcTemplate.query(SQL_COGER_TODOS, new CursosMapper());

			} else {
				listado = (ArrayList<Cursos>) this.jdbcTemplate.query(SQL_FILTRO, new Object[] { filtro },
						new CursosMapper());
			}

		} catch (EmptyResultDataAccessException e) {

			this.LOG.warn("Crea un curso! Aún no tienes ninguno", e);

		} catch (Exception e) {

			this.LOG.error(ERROR_INESPERADO, e);

		}

		return listado;
	}

	@Override()
	public List<Cursos> cogerUltimosDiez() {
		ArrayList<Cursos> listando = new ArrayList<Cursos>();

		try {

			listando = (ArrayList<Cursos>) this.jdbcTemplate.query(SQL_COGER_ULTIMOS_DIEZ, new CursosMapper());

		} catch (EmptyResultDataAccessException e) {

			this.LOG.warn("Crea un curso! Aún no tienes ninguno", e);

		} catch (Exception e) {

			this.LOG.error(ERROR_INESPERADO, e);

		}

		return listando;
	}

	@Override()
	public Cursos getById(long id) {
		Cursos cursos = new Cursos();

		try {

			cursos = this.jdbcTemplate.queryForObject(SQL_GET_BY_ID, new Object[] { id }, new CursosMapper());

		} catch (EmptyResultDataAccessException e) {

			this.LOG.warn("Crea un curso! Aún no tienes ninguno", e);

		} catch (Exception e) {

			this.LOG.error(ERROR_INESPERADO, e);

		}

		return cursos;
	}

	@Override()
	public boolean insertar(final Cursos cursos) {
		boolean resul = false;

		try {
			KeyHolder keyHolder = new GeneratedKeyHolder();

			int affectedeRows = this.jdbcTemplate.update(new PreparedStatementCreator() {

				@Override()
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					PreparedStatement ps = conn.prepareStatement(SQL_INSERTAR, Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, cursos.getNombre());
					ps.setString(2, cursos.getCodigo());

					return ps;
				}
			}, keyHolder);

			if (affectedeRows == 1) {
				cursos.setId(keyHolder.getKey().longValue());
				resul = true;
			}
		} catch (Exception e) {

			this.LOG.error(ERROR_INESPERADO, e);

		}

		return resul;
	}

	@Override()
	public boolean actualizar(Cursos cursos) {
		boolean resul = false;

		try {

			Object[] argumentos = { cursos.getNombre(), cursos.getCodigo(), cursos.getId() };
			int affectedRows = this.jdbcTemplate.update(SQL_ACTUALIZAR, argumentos);

			if (affectedRows == 1) {
				resul = true;
			}

		} catch (Exception e) {

			this.LOG.error(ERROR_INESPERADO, e);

		}

		return resul;
	}

	@Override()
	public boolean eliminar(long id) {
		boolean resul = false;

		try {

			int affectedRows = this.jdbcTemplate.update(SQL_ELIMINAR, id);

			if (affectedRows == 1) {
				resul = true;
			}
		} catch (DataIntegrityViolationException e) {

			this.LOG.warn("No se puede eliminar", e);

		} catch (Exception e) {

			this.LOG.error(ERROR_INESPERADO, e);

		}

		return resul;
	}

}
