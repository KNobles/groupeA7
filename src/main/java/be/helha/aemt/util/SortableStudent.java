package be.helha.aemt.util;

import java.util.Arrays;
import java.util.Comparator;
import javax.faces.model.DataModel;

public class SortableStudent<E> extends DataModel<E>{

	DataModel<E> model;
	private Integer[] rows;
	
	SortableStudent(DataModel<E> model){
		this.model = model;
		initRows();
	}
	
	public void initRows(){
		int rowCount = this.model.getRowCount();
		if(rowCount != -1){
			this.rows = new Integer[rowCount];
			for(int i = 0; i < rowCount; ++i){
				this.rows[i] = i;
				
			}
		}
	}
	
	public void sortBy(final Comparator<E> comparator){
		Comparator<Integer> rowComp = new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2){
				E o1 = getData(i1);
				E o2 = getData(i2);
				return comparator.compare(o1, o2);
			}
		};
		Arrays.sort(this.rows, rowComp);
		
	}
	
	private E getData(int row){
		int originalRowIndex = this.model.getRowIndex();
		
		this.model.setRowIndex(row);
		E newRowData = this.model.getRowData();
		this.model.setRowIndex(originalRowIndex);
		
		return newRowData;
	}
	
	@Override
	public void setRowIndex(int rowIndex) {

		if(0 <= rowIndex && rowIndex < this.rows.length){
			this.model.setRowIndex(this.rows[rowIndex]);
		}else{
			this.model.setRowIndex(rowIndex);
		}
	}
	
	@Override
	public boolean isRowAvailable() {
		return this.model.isRowAvailable();
	}

	@Override
	public int getRowCount() {
		return this.model.getRowCount();
	}

	@Override
	public E getRowData() {
		return this.model.getRowData();
	}

	@Override
	public int getRowIndex() {
		return this.model.getRowIndex();
	}

	@Override
	public Object getWrappedData() {
		return this.model.getWrappedData();
	}

	@Override
	public void setWrappedData(Object data) {
		
		this.model.setWrappedData(data);
		initRows();
		
	}
	
}