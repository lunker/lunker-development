import sys


class Application {
    public static void main(String[] args){
        Solution solution=new Solution();
        solution.run();
    }
}

class Solution{
    private int n=0;
    private int[] inputArr=null;
    private int result=0;

    public void run(){
        getInput();
        solve();
        print_result();
    }

    public void getInput(){
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInput();

        inputArr = new int[n];

        for(int idx=0; idx<n; idx++){
            inputArr[idx]=scanner.nextInt()
        }
    }

    public void solve(){
        List<Integer>
    }

    public void print_result(){
        System.out.println(result);
    }
}

    def __init__(self):
        self.n = 0
        self.input_arr = None
        self.result = None

        self.min = 0

    def get_input(self):
        self.n = input()
        self.input_str = input()

        self.input_arr = self.input_str.split(' ')

    def solve(self):
        self.input_arr.sort(reverse=True)

        self.min = sys.maxsize

        for idx in range(1, len(self.input_arr) - 1):
            if self.min > self.input_arr[idx] - self.input_arr[idx - 1]:
                self.min = self.input_arr[idx] - self.input_arr[idx - 1]

        result = min

    def print_result(self):
        print(self.result)

    def run(self):
        self.get_input()
        self.solve()
        self.print_result()


if __name__ == '__main__':
    Solution().run()