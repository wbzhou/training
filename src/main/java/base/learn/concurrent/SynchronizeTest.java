package base.learn.concurrent;
/**
@author :zhouwenbin
@time   :2016-6-6
@comment:
 **/
public class SynchronizeTest {

	 public synchronized void isSyncA() throws Exception{
		 System.out.println("isSyncA");
		 for(int i=0;i<2;i++){
				Thread.sleep(5000);
				
			}
	 }
     public synchronized void isSyncB() throws Exception{
    	 System.out.println("isSyncB");
     }
     public static synchronized void cSyncA() throws Exception{
    	 System.out.println("isSyncA");
		 for(int i=0;i<2;i++){
				Thread.sleep(5000);
				
			}
    	 
     }
     public static synchronized void cSyncB() throws Exception{
    	 System.out.println("isSyncB");
    	 
     }
     
	public static void main(String[] args) throws Exception {
		SynchronizeTest test1=new SynchronizeTest();
		SynchronizeTest test2=new SynchronizeTest();
//		test1.isSyncA();
//		test2.isSyncB();
		SynchronizeTest.cSyncA();

	}

}
