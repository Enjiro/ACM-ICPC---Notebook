public static Random rand = new Random();
public static long v, ans=1, fact;
public static long gcd(long x, long y)
{
    if(y==0)
        return x;
    return gcd(y, x%y);
}
public static long rho(long x)
{
    long a, b, cnt=2;
    a=b=rand.nextLong()%x;
    for(long i=1; ;i++)
    {
        BigInteger Ba=BigInteger.valueOf(a);
        BigInteger Bx=BigInteger.valueOf(x);
        BigInteger aux=Ba.multiply(Ba).add(BigInteger.valueOf(2)).mod(Bx);
        a=aux.longValue();
        if(a==b)
            return 0;
        long g=gcd(Math.abs(a-b),x);
        if(g!=1)
            return g;
        if(i==cnt)
        {
            b=a;
            cnt*=2;
        }
    }
}
public static void solve(long x)
{
    BigInteger Bx=BigInteger.valueOf(x);
    if(Bx.isProbablePrime(20))
    {
        long cnt=0;
        while(v%x==0)
        {
            v/=x;
            cnt++;
        }
        ans*=(cnt+1);
        if(v!=1)
            solve(v);
    }
    else
    {
        for(fact=rho(x); fact==0; fact=rho(x)){}
        solve(fact);
    }
}
public static void main(String[] args) throws Exception
{
    ans=1;
    v=sc.nextLong();
    if(v!=1)
        solve(v);
    System.out.println(ans);
}