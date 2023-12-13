/*
 * Copyright (c) 2023 Robert Bosch Manufacturing Solutions GmbH, Germany. All rights reserved.
 */

package com.test;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

public class StartupListener {

   @Autowired
   private DSLContext dslContext;

   @EventListener( ApplicationReadyEvent.class )
   public void doSomethingAfterStartup() {
      dslContext.settings().setBatchSize( 100 );

      final StringBuilder stringBuilder = new StringBuilder( "SELECT * FROM test WITH (TABLOCKX, HOLDLOCK)" );
      stringBuilder.append( " WHERE 0 = 1" );
      stringBuilder.append( " WAITFOR DELAY '00:01'" );
      try {
         dslContext.query( stringBuilder.toString() ).execute();
      } catch ( final Exception e ) {
         e.printStackTrace();
      }
      System.out.println( "Finish" );

   }
}
