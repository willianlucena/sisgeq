package br.uern.sisgeq.controller;

import br.uern.sisgeq.dao.CursoDao;
import br.uern.sisgeq.model.Curso;
import br.uern.sisgeq.util.Sessao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author rafael
 */
@ManagedBean(name = "cursoManagedBean")
@ViewScoped
public class CursoController extends Sessao {

    private int inicio;
    private int fim;
    private DataModel cursoNomes;
    private CursoDao cursoDao;
    private int recordCount = 1000;
    private int pageSize = 10;
    private Curso curso = new Curso();

    /** Creates a new instance of CursoController */
    public CursoController() {
        super();
        this.inicio = 1;
        this.fim = 10;
    }

    public CursoController(int inicio, int fim) {
        super();
        this.inicio = inicio;
        this.fim = fim;
    }
    
    public void adicionarCurso() {
        curso = new Curso();
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public boolean isHasNextPage() {
        if (fim + pageSize <= recordCount) {
            return true;
        }
        return false;
    }

    public boolean isHasPreviousPage() {
        if (inicio - pageSize > 0) {
            return true;
        }
        return false;
    }

    public String next() {
        inicio = fim + 1;
        fim = fim + pageSize;
        cursoNomes =  null;
        return "index";
    }

    public String previous() {
        inicio = inicio - pageSize;
        fim = fim - pageSize;
        cursoNomes =  null;
        return "index";
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public String prepareView(){
        curso = (Curso) getCursoNomes().getRowData();
        return "browse";
    }

    public String prepareList(){
        cursoNomes =  null;
        return "index";
    }

    public CursoDao getCursoDao() {
        return cursoDao;
    }

    public void setCursoDao(CursoDao cursoDao) {
        this.cursoDao = cursoDao;
    }

    public DataModel getCursoNomes() {
        if (cursoNomes == null) {
            cursoNomes = new ListDataModel(cursoDao.getCursos(inicio, fim));
        }
        return cursoNomes;
    }

    public void setCursoNomes(DataModel cursoNomes) {
        this.cursoNomes = cursoNomes;
    }

    public int getFim() {
        return fim;
    }

    public void setFim(int fim) {
        this.fim = fim;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

}
