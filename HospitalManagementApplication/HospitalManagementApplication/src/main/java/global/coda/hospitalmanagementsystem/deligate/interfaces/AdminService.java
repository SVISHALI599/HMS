package global.coda.hospitalmanagementsystem.deligate.interfaces;

import java.util.List;

public interface AdminService {
  public int addUser(int roleId, List<String> userData);

  public int addHospital(String hospitalName);

  public int addBranch(List<String> branchData);

  public boolean modifyUser(int userId, String userAttributeName,
      String userAttributeValue);

  public boolean modifyHospital(int adminId, int hospitalId,
      String hospitalName);

  public boolean modifyBranch(int adminId, int branchId, String branchData);
}
