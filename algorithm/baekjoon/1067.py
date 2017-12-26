class Sol:

    def __init__(self):
        self.x = list()
        self.y = list()
        self.n = 0

    def run(self):
        self.read_input()
        result = self.solve()
        print(result)
        pass

    def read_input(self):
        self.n = int(input())

        x = input()

        self.x = list(map(lambda x: int(x), x.split(' ')))

        y = input()
        # self.y = y.split(' ')
        self.y = list(map(lambda x: int(x), y.split(' ')))

        # for idx in range(self.n):
        #     self.x.append(int(input()))

        # for idx in range(self.n):
        #     self.y.append(int(input()))

    def solve(self):
        self.x.sort()
        self.y.sort()
        sum = 0

        for idx in range(self.n):
            sum += self.x[idx] * self.y[idx]
        return sum


if __name__ == '__main__':
    Sol().run()