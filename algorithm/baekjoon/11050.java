class Application {
    public static void main(String[] args){
        Solution solution=new Solution();
        solution.run();
    }
}

class Solution{
    private int n=0;
    private int k=0;

    private int result=0;

    public void run(){
        getInput();
        solve();
        print_result();
    }

    public void getInput(){
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
    }

    public void solve(){

    }

    public void print_result(){
        System.out.println(result);
    }


}