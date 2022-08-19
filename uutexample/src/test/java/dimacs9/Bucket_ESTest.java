/*
 * This file was automatically generated by EvoSuite
 * Thu Aug 18 23:25:57 GMT 2022
 */

package dimacs9;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import dimacs9.Bucket;
import dimacs9.VertexPulse;
import org.junit.runner.RunWith;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class Bucket_ESTest extends Bucket_ESTest_scaffolding {

  @Test(timeout = 11000)
  public void test00()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1));
      Bucket bucket0 = new Bucket(vertexPulse0, Integer.MAX_VALUE);
      bucket0.setKey(Integer.MAX_VALUE);
      assertEquals(Integer.MAX_VALUE, bucket0.getKey());
  }

  @Test(timeout = 11000)
  public void test01()  throws Throwable  {
      Bucket bucket0 = new Bucket(0);
      int int0 = bucket0.getKey();
      assertEquals(0, int0);
  }

  @Test(timeout = 11000)
  public void test02()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1));
      Bucket bucket0 = new Bucket(vertexPulse0, Integer.MAX_VALUE);
      bucket0.deleteLabeledVertexTime();
      assertTrue(bucket0.empty());
      
      bucket0.insertVertexDist(vertexPulse0);
      assertEquals(Integer.MAX_VALUE, bucket0.getKey());
  }

  @Test(timeout = 11000)
  public void test03()  throws Throwable  {
      Bucket bucket0 = new Bucket((-4028));
      VertexPulse vertexPulse0 = new VertexPulse(1);
      bucket0.insertVertexTime(vertexPulse0);
      VertexPulse vertexPulse1 = new VertexPulse(569);
      VertexPulse vertexPulse2 = vertexPulse1.getBLeftDist();
      bucket0.insertVertexDist(vertexPulse2);
      boolean boolean0 = bucket0.deleteLabeledVertexDist();
      assertFalse(bucket0.empty());
      assertFalse(boolean0);
  }

  @Test(timeout = 11000)
  public void test04()  throws Throwable  {
      Bucket bucket0 = new Bucket(0);
      VertexPulse vertexPulse0 = new VertexPulse(0);
      bucket0.insertVertexTime(vertexPulse0);
      VertexPulse vertexPulse1 = new VertexPulse((-834));
      VertexPulse vertexPulse2 = vertexPulse1.getBRigthDist();
      bucket0.insertVertexTime(vertexPulse2);
      bucket0.deleteToMoveTime(vertexPulse2);
      bucket0.insertVertexTime(vertexPulse2);
      boolean boolean0 = bucket0.deleteLabeledVertexTime();
      assertFalse(bucket0.empty());
      assertFalse(boolean0);
  }

  @Test(timeout = 11000)
  public void test05()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1));
      Bucket bucket0 = new Bucket(vertexPulse0, Integer.MAX_VALUE);
      bucket0.deleteToMoveDist(vertexPulse0);
      bucket0.getEntrance();
      assertTrue(bucket0.empty());
  }

  @Test(timeout = 11000)
  public void test06()  throws Throwable  {
      Bucket bucket0 = new Bucket(0);
      VertexPulse vertexPulse0 = new VertexPulse(0);
      bucket0.insertVertexTime(vertexPulse0);
      VertexPulse vertexPulse1 = new VertexPulse((-834));
      VertexPulse vertexPulse2 = vertexPulse1.getBRigthDist();
      bucket0.insertVertexDist(vertexPulse2);
      boolean boolean0 = bucket0.deleteToMoveDist(vertexPulse2);
      assertFalse(bucket0.empty());
      assertFalse(boolean0);
  }

  @Test(timeout = 11000)
  public void test07()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(0);
      Bucket bucket0 = new Bucket(vertexPulse0, Integer.MAX_VALUE);
      bucket0.deleteToMoveDist(vertexPulse0);
      boolean boolean0 = bucket0.empty();
      assertTrue(boolean0);
  }

  @Test(timeout = 11000)
  public void test08()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse((-1));
      Bucket bucket0 = new Bucket(vertexPulse0, Integer.MAX_VALUE);
      boolean boolean0 = bucket0.empty();
      assertFalse(boolean0);
      assertEquals(Integer.MAX_VALUE, bucket0.getKey());
  }

  @Test(timeout = 11000)
  public void test09()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(19);
      Bucket bucket0 = new Bucket(vertexPulse0, 19);
      bucket0.deleteLabeledVertexDist();
      // Undeclared exception!
      try { 
        bucket0.deleteLabeledVertexDist();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("dimacs9.Bucket", e);
      }
  }

  @Test(timeout = 11000)
  public void test10()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(1);
      Bucket bucket0 = new Bucket(vertexPulse0, 1);
      bucket0.deleteLabeledVertexDist();
      // Undeclared exception!
      try { 
        bucket0.deleteLabeledVertexTime();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("dimacs9.Bucket", e);
      }
  }

  @Test(timeout = 11000)
  public void test11()  throws Throwable  {
      Bucket bucket0 = new Bucket(Integer.MAX_VALUE);
      VertexPulse vertexPulse0 = new VertexPulse(Integer.MAX_VALUE);
      bucket0.insertVertexDist(vertexPulse0);
      bucket0.deleteToMoveTime(vertexPulse0);
      // Undeclared exception!
      try { 
        bucket0.deleteToMoveDist(vertexPulse0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("dimacs9.Bucket", e);
      }
  }

  @Test(timeout = 11000)
  public void test12()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(0);
      Bucket bucket0 = new Bucket(vertexPulse0, Integer.MAX_VALUE);
      bucket0.deleteToMoveDist(vertexPulse0);
      // Undeclared exception!
      try { 
        bucket0.deleteToMoveTime(vertexPulse0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("dimacs9.Bucket", e);
      }
  }

  @Test(timeout = 11000)
  public void test13()  throws Throwable  {
      Bucket bucket0 = new Bucket(0);
      VertexPulse vertexPulse0 = new VertexPulse((-2663));
      bucket0.insertVertexDist(vertexPulse0);
      // Undeclared exception!
      try { 
        bucket0.insertVertexDist((VertexPulse) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("dimacs9.VertexPulse", e);
      }
  }

  @Test(timeout = 11000)
  public void test14()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(1);
      Bucket bucket0 = new Bucket((-1442));
      bucket0.insertVertexDist(vertexPulse0);
      // Undeclared exception!
      try { 
        bucket0.insertVertexTime((VertexPulse) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("dimacs9.VertexPulse", e);
      }
  }

  @Test(timeout = 11000)
  public void test15()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(2415);
      vertexPulse0.setMinDist((-1));
      Bucket bucket0 = new Bucket(vertexPulse0, 4477);
      bucket0.getEntrance();
      assertEquals(4477, bucket0.getKey());
  }

  @Test(timeout = 11000)
  public void test16()  throws Throwable  {
      Bucket bucket0 = new Bucket(0);
      VertexPulse vertexPulse0 = new VertexPulse(0);
      vertexPulse0.setMinDist(0);
      bucket0.insertVertexTime(vertexPulse0);
      bucket0.getEntrance();
      assertEquals(0, bucket0.getKey());
  }

  @Test(timeout = 11000)
  public void test17()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(1);
      vertexPulse0.setMaxDist((-1442));
      Bucket bucket0 = new Bucket(vertexPulse0, 2385);
      bucket0.getEntrance();
      assertEquals(2385, bucket0.getKey());
  }

  @Test(timeout = 11000)
  public void test18()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(Integer.MAX_VALUE);
      Bucket bucket0 = new Bucket(vertexPulse0, Integer.MAX_VALUE);
      vertexPulse0.setMaxDist(Integer.MAX_VALUE);
      bucket0.getEntrance();
      assertEquals(Integer.MAX_VALUE, bucket0.getKey());
  }

  @Test(timeout = 11000)
  public void test19()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(1);
      Bucket bucket0 = new Bucket(vertexPulse0, 1);
      vertexPulse0.setMaxTime((-717));
      bucket0.getEntrance();
      assertEquals(1, bucket0.getKey());
  }

  @Test(timeout = 11000)
  public void test20()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(1);
      Bucket bucket0 = new Bucket(vertexPulse0, 1);
      vertexPulse0.setMaxTime(Integer.MAX_VALUE);
      bucket0.getEntrance();
      assertEquals(1, bucket0.getKey());
  }

  @Test(timeout = 11000)
  public void test21()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(1);
      Bucket bucket0 = new Bucket(vertexPulse0, 1);
      vertexPulse0.minTime = (-1235);
      bucket0.getEntrance();
      assertEquals(1, bucket0.getKey());
  }

  @Test(timeout = 11000)
  public void test22()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(0);
      Bucket bucket0 = new Bucket(vertexPulse0, 0);
      vertexPulse0.minTime = 0;
      bucket0.getEntrance();
      assertEquals(0, bucket0.getKey());
  }

  @Test(timeout = 11000)
  public void test23()  throws Throwable  {
      Bucket bucket0 = new Bucket((-99));
      VertexPulse vertexPulse0 = new VertexPulse((-99));
      vertexPulse0.setInsertedDist();
      bucket0.insertVertexTime(vertexPulse0);
      bucket0.getEntrance();
      assertEquals((-99), bucket0.getKey());
  }

  @Test(timeout = 11000)
  public void test24()  throws Throwable  {
      Bucket bucket0 = new Bucket(1);
      VertexPulse vertexPulse0 = new VertexPulse((-81));
      vertexPulse0.setInsertedTime();
      bucket0.insertVertexDist(vertexPulse0);
      bucket0.getEntrance();
      assertEquals(1, bucket0.getKey());
  }

  @Test(timeout = 11000)
  public void test25()  throws Throwable  {
      Bucket bucket0 = new Bucket((-4));
      int int0 = bucket0.getKey();
      assertEquals((-4), int0);
  }

  @Test(timeout = 11000)
  public void test26()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(1);
      Bucket bucket0 = new Bucket(vertexPulse0, 2385);
      int int0 = bucket0.getKey();
      assertEquals(2385, int0);
  }

  @Test(timeout = 11000)
  public void test27()  throws Throwable  {
      VertexPulse vertexPulse0 = new VertexPulse(0);
      Bucket bucket0 = new Bucket(vertexPulse0, Integer.MAX_VALUE);
      VertexPulse vertexPulse1 = new VertexPulse(1);
      boolean boolean0 = bucket0.deleteToMoveDist(vertexPulse1);
      assertTrue(bucket0.empty());
      assertTrue(boolean0);
  }

  @Test(timeout = 11000)
  public void test28()  throws Throwable  {
      Bucket bucket0 = new Bucket(0);
      VertexPulse vertexPulse0 = new VertexPulse(2135);
      bucket0.insertVertexDist(vertexPulse0);
      VertexPulse vertexPulse1 = new VertexPulse(2726);
      boolean boolean0 = bucket0.deleteToMoveTime(vertexPulse1);
      assertTrue(bucket0.empty());
      assertTrue(boolean0);
  }
}
