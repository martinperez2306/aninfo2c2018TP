package com.fiuba.aninfo.db;

import java.util.List;

/**
 * Interfaz que implementaran las tablas para la base de datos
 * Cada tabla tendra asociada una entidad la cual almacenara
 * @author martin
 * * @param <T> Elemento o entidad a almacenar
 */
public interface TableInterface<T> {
	
	public void insert(T element);
	
	public List<T>
	select();
	
	public void update(T element);
	
	public void delete(T element);

}
