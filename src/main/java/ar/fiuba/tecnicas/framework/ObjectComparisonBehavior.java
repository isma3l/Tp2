/*
    Interface que declara un metodo que compara dos objetos
 */

package ar.fiuba.tecnicas.framework;

public interface ObjectComparisonBehavior {
    public <T> boolean compare(T obj,T obj2);
}
