package main.domain;

/**
 * Created by eananthaneshan on 5/11/17.
 */
public class MinDep {
    String ministry;
    String department;

    public MinDep(String ministry, String department) {
        this.ministry = ministry.toUpperCase();
        this.department = department.toUpperCase();
        validate();
    }

    public MinDep(String min_dep) {
        String[] a = min_dep.split("_");
        this.ministry = a[0].toUpperCase();
        this.department = a[1].toUpperCase();
        validate();
    }

    private void validate() {
        if (ministry.length() != 3) throw new InvalidMinistryCode();
        if (department.length() != 3) throw new InvalidDepartmentCode();
    }

    public String getMin_Dep() {
        return ministry + "_" + department;
    }

    public String getMinDep() {
        return ministry + department;
    }

    @Override
    public String toString() {
        return getMin_Dep();
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (!MinDep.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final MinDep other = (MinDep) obj;
        if ((this.ministry == null) ? (other.ministry != null) : !this.ministry.equals(other.ministry)) {
            return false;
        }
        if ((this.department == null) ? (other.department != null) : !this.department.equals(other.department)) {
            return false;
        }
        return true;

    }


    public class InvalidMinistryCode extends RuntimeException {
    }

    public class InvalidDepartmentCode extends RuntimeException {
    }
}
