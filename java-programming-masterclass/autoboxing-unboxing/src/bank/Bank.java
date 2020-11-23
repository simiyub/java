package bank;

import java.util.ArrayList;

public class Bank {

    private final String name;
    private final String mainBranch;
    private final String mainBranchLocation;
    private ArrayList<Branch> branches;


    private Bank(String name, String mainBranch, String mainBranchLocation) {
        this.name = name;
        this.mainBranch=mainBranch;
        this.mainBranchLocation = mainBranchLocation;
    }
     static Bank bank(String name, String mainBranch, String mainBranchLocation){
        return new Bank(name,mainBranch,mainBranchLocation);
    }

    public String getName() {
        return name;
    }

    public String getMainBranch() {
        return mainBranch;
    }

    public String getMainBranchLocation() {
        return mainBranchLocation;
    }

     boolean branch(Branch branch) {
        if(branches==null) {
            branches = new ArrayList<>();
        }
        branches.add(branch);
        return branches.contains(branch);
    }

    public Branch findBranch(String branchName, String branchLocation) {
        for(int i=0;i<branches.size();i++){
            Branch branch = branches.get(i);
            if(branch.getBranchName().equalsIgnoreCase(branchName)
            && branch.getBranchLocation().equalsIgnoreCase(branchLocation)){
                return branch;
            }
        }
        return null;
    }
}
