from time import clock

def fib(n):
    if n<2:
        return n
    else:
        return fib(n-1)+fib(n-2)


for i in range(0,51):
    t=clock()
    l=fib(i)
    print("fib[",i,"] is",l,"running time is %f s" %(clock()-t))

