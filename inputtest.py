import sys
import math

class Square:

    def __init__(self, size, style):
        # the size of the square
        self.size = size
        self.style = style

    def perimeter(self):
        return int(self.size * 4)

    def area(self):
        return int(math.pow(self.size, 2))

    def draw(self):
        j = ''
        if self.style == 1:
            for i in range(self.size):
                j = j + '*'
        elif self.style == 2:
            for i in range(self.size):
                if i == 0 or i == (self.size-1):
                    j = j + '*'
                else:
                    j = j + ' '

        for i in range(self.size):
            print j

def main():
    while True:
        user_input = raw_input("Enter: ")
        if user_input == ' ':
            draw()
        elif user_input == 'n':
            sys.exit()
        else:
            try:
                user_input = int(user_input)
                square = Square(user_input, 1)
                square.draw()
                print 'this is a square of size ' + str(user_input)
            except ValueError:
                print 'this isn\' an integer'

def test():
    square = Square(2, 1)
    if square.perimeter() != 8:
        print 'failed perimeter test'
    if square.area() != 4:
        print 'failed area test'
    square.draw()

if __name__ == '__main__':
    test()
    main()
