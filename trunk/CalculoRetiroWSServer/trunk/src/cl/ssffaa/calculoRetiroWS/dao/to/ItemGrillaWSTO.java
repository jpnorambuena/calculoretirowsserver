/**
 * ItemGrillaWSTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.ssffaa.calculoRetiroWS.dao.to;

public class ItemGrillaWSTO  implements java.io.Serializable {
    private java.lang.String id;

    private cl.ssffaa.calculoRetiroWS.dao.to.ItemColumnaWSTO[] listaColumnas;

    public ItemGrillaWSTO() {
    }

    public ItemGrillaWSTO(
           java.lang.String id,
           cl.ssffaa.calculoRetiroWS.dao.to.ItemColumnaWSTO[] listaColumnas) {
           this.id = id;
           this.listaColumnas = listaColumnas;
    }


    /**
     * Gets the id value for this ItemGrillaWSTO.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this ItemGrillaWSTO.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the listaColumnas value for this ItemGrillaWSTO.
     * 
     * @return listaColumnas
     */
    public cl.ssffaa.calculoRetiroWS.dao.to.ItemColumnaWSTO[] getListaColumnas() {
        return listaColumnas;
    }


    /**
     * Sets the listaColumnas value for this ItemGrillaWSTO.
     * 
     * @param listaColumnas
     */
    public void setListaColumnas(cl.ssffaa.calculoRetiroWS.dao.to.ItemColumnaWSTO[] listaColumnas) {
        this.listaColumnas = listaColumnas;
    }

    public cl.ssffaa.calculoRetiroWS.dao.to.ItemColumnaWSTO getListaColumnas(int i) {
        return this.listaColumnas[i];
    }

    public void setListaColumnas(int i, cl.ssffaa.calculoRetiroWS.dao.to.ItemColumnaWSTO _value) {
        this.listaColumnas[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ItemGrillaWSTO)) return false;
        ItemGrillaWSTO other = (ItemGrillaWSTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.listaColumnas==null && other.getListaColumnas()==null) || 
             (this.listaColumnas!=null &&
              java.util.Arrays.equals(this.listaColumnas, other.getListaColumnas())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getListaColumnas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaColumnas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaColumnas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ItemGrillaWSTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://transferObject.dao.ssffaa.cl", "ItemGrillaWSTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://transferObject.dao.ssffaa.cl", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaColumnas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://transferObject.dao.ssffaa.cl", "listaColumnas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://transferObject.dao.ssffaa.cl", "ItemColumnaWSTO"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
