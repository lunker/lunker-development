import sys


class Solution:

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