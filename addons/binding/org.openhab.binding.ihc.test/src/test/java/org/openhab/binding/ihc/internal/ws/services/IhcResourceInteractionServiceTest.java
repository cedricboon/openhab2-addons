/**
 * Copyright (c) 2010-2019 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.ihc.internal.ws.services;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openhab.binding.ihc.internal.ws.ResourceFileUtils;
import org.openhab.binding.ihc.internal.ws.exeptions.IhcExecption;
import org.openhab.binding.ihc.internal.ws.http.IhcConnectionPool;
import org.openhab.binding.ihc.internal.ws.resourcevalues.WSBooleanValue;
import org.openhab.binding.ihc.internal.ws.resourcevalues.WSDateValue;
import org.openhab.binding.ihc.internal.ws.resourcevalues.WSEnumValue;
import org.openhab.binding.ihc.internal.ws.resourcevalues.WSFloatingPointValue;
import org.openhab.binding.ihc.internal.ws.resourcevalues.WSIntegerValue;
import org.openhab.binding.ihc.internal.ws.resourcevalues.WSResourceValue;
import org.openhab.binding.ihc.internal.ws.resourcevalues.WSTimeValue;
import org.openhab.binding.ihc.internal.ws.resourcevalues.WSTimerValue;
import org.openhab.binding.ihc.internal.ws.resourcevalues.WSWeekdayValue;

/**
 * Test for IHC / ELKO binding
 *
 * @author Pauli Anttila - Initial contribution
 */
public class IhcResourceInteractionServiceTest {

    private IhcResourceInteractionService ihcResourceInteractionService;
    private final String host = "1.1.1.1";
    private final String url = "https://1.1.1.1/ws/ResourceInteractionService";

    @Before
    public void setUp() throws IhcExecption, SocketTimeoutException {
        ihcResourceInteractionService = spy(new IhcResourceInteractionService(host, 0, new IhcConnectionPool()));

        final String query = ResourceFileUtils.getFileContent("src/test/resources/ResourceValueQueryTemplate.xml");
        final String response11111 = ResourceFileUtils
                .getFileContent("src/test/resources/ResourceValueQueryResponse11111.xml");
        final String response22222 = ResourceFileUtils
                .getFileContent("src/test/resources/ResourceValueQueryResponse22222.xml");
        final String response33333 = ResourceFileUtils
                .getFileContent("src/test/resources/ResourceValueQueryResponse33333.xml");
        final String response44444 = ResourceFileUtils
                .getFileContent("src/test/resources/ResourceValueQueryResponse44444.xml");
        final String response55555 = ResourceFileUtils
                .getFileContent("src/test/resources/ResourceValueQueryResponse55555.xml");
        final String response66666 = ResourceFileUtils
                .getFileContent("src/test/resources/ResourceValueQueryResponse66666.xml");
        final String response77777 = ResourceFileUtils
                .getFileContent("src/test/resources/ResourceValueQueryResponse77777.xml");
        final String response88888 = ResourceFileUtils
                .getFileContent("src/test/resources/ResourceValueQueryResponse88888.xml");

        doReturn(response11111).when(ihcResourceInteractionService).sendQuery(eq(url), any(),
                eq(String.format(query, 11111)), anyInt());
        doReturn(response22222).when(ihcResourceInteractionService).sendQuery(eq(url), any(),
                eq(String.format(query, 22222)), anyInt());
        doReturn(response33333).when(ihcResourceInteractionService).sendQuery(eq(url), any(),
                eq(String.format(query, 33333)), anyInt());
        doReturn(response44444).when(ihcResourceInteractionService).sendQuery(eq(url), any(),
                eq(String.format(query, 44444)), anyInt());
        doReturn(response55555).when(ihcResourceInteractionService).sendQuery(eq(url), any(),
                eq(String.format(query, 55555)), anyInt());
        doReturn(response66666).when(ihcResourceInteractionService).sendQuery(eq(url), any(),
                eq(String.format(query, 66666)), anyInt());
        doReturn(response77777).when(ihcResourceInteractionService).sendQuery(eq(url), any(),
                eq(String.format(query, 77777)), anyInt());
        doReturn(response88888).when(ihcResourceInteractionService).sendQuery(eq(url), any(),
                eq(String.format(query, 88888)), anyInt());

        final String updateOkResult = ResourceFileUtils
                .getFileContent("src/test/resources/ResourceValueUpdateOkResult.xml");
        final String update100001 = ResourceFileUtils
                .getFileContent("src/test/resources/ResourceValueUpdate100001.xml");
        final String update200002 = ResourceFileUtils
                .getFileContent("src/test/resources/ResourceValueUpdate200002.xml");
        final String update300003 = ResourceFileUtils
                .getFileContent("src/test/resources/ResourceValueUpdate300003.xml");
        final String update400004 = ResourceFileUtils
                .getFileContent("src/test/resources/ResourceValueUpdate400004.xml");
        final String update500005 = ResourceFileUtils
                .getFileContent("src/test/resources/ResourceValueUpdate500005.xml");
        final String update600006 = ResourceFileUtils
                .getFileContent("src/test/resources/ResourceValueUpdate600006.xml");
        final String update700007 = ResourceFileUtils
                .getFileContent("src/test/resources/ResourceValueUpdate700007.xml");
        final String update800008 = ResourceFileUtils
                .getFileContent("src/test/resources/ResourceValueUpdate800008.xml");

        doReturn(updateOkResult).when(ihcResourceInteractionService).sendQuery(eq(url), any(), eq(update100001),
                anyInt());
        doReturn(updateOkResult).when(ihcResourceInteractionService).sendQuery(eq(url), any(), eq(update200002),
                anyInt());
        doReturn(updateOkResult).when(ihcResourceInteractionService).sendQuery(eq(url), any(), eq(update300003),
                anyInt());
        doReturn(updateOkResult).when(ihcResourceInteractionService).sendQuery(eq(url), any(), eq(update400004),
                anyInt());
        doReturn(updateOkResult).when(ihcResourceInteractionService).sendQuery(eq(url), any(), eq(update500005),
                anyInt());
        doReturn(updateOkResult).when(ihcResourceInteractionService).sendQuery(eq(url), any(), eq(update600006),
                anyInt());
        doReturn(updateOkResult).when(ihcResourceInteractionService).sendQuery(eq(url), any(), eq(update700007),
                anyInt());
        doReturn(updateOkResult).when(ihcResourceInteractionService).sendQuery(eq(url), any(), eq(update800008),
                anyInt());

        final String updateFailureResult = ResourceFileUtils
                .getFileContent("src/test/resources/ResourceValueUpdateFailureResult.xml");
        final String update100011 = ResourceFileUtils
                .getFileContent("src/test/resources/ResourceValueUpdate100011.xml");

        doReturn(updateFailureResult).when(ihcResourceInteractionService).sendQuery(eq(url), any(), eq(update100011),
                anyInt());

        final String resourceValueNotificationsQuery = ResourceFileUtils
                .getFileContent("src/test/resources/ResourceValueNotificationsQuery.xml");
        final String resourceValueNotificationsResponse = ResourceFileUtils
                .getFileContent("src/test/resources/ResourceValueNotificationsResponse.xml");

        doReturn(resourceValueNotificationsResponse).when(ihcResourceInteractionService).sendQuery(eq(url), any(),
                eq(resourceValueNotificationsQuery), anyInt());
    }

    @Test
    public void testWSBooleanValueQuery() throws IhcExecption {
        final WSBooleanValue val = (WSBooleanValue) ihcResourceInteractionService.resourceQuery(11111);
        assertEquals(11111, val.getResourceID());
        assertEquals(true, val.booleanValue());
    }

    @Test
    public void testWSFloatingPointValueQuery() throws IhcExecption {
        final WSFloatingPointValue val = (WSFloatingPointValue) ihcResourceInteractionService.resourceQuery(22222);
        assertEquals(22222, val.getResourceID());
        assertEquals(24.399999618530273, val.getFloatingPointValue(), 0.000001);
        assertEquals(-1000.0, val.getMinimumValue(), 0.01);
        assertEquals(1000.0, val.getMaximumValue(), 0.01);
    }

    @Test
    public void testWSEnumValueQuery() throws IhcExecption {
        final WSEnumValue val = (WSEnumValue) ihcResourceInteractionService.resourceQuery(33333);
        assertEquals(33333, val.getResourceID());
        assertEquals(4236359, val.getDefinitionTypeID());
        assertEquals(4236872, val.getEnumValueID());
        assertEquals("test value", val.getEnumName());
    }

    @Test
    public void testWSIntegerValueQuery() throws IhcExecption {
        final WSIntegerValue val = (WSIntegerValue) ihcResourceInteractionService.resourceQuery(44444);
        assertEquals(44444, val.getResourceID());
        assertEquals(424561, val.getInteger());
        assertEquals(-2147483648, val.getMinimumValue());
        assertEquals(2147483647, val.getMaximumValue());
    }

    @Test
    public void testWSTimerValueQuery() throws IhcExecption {
        final WSTimerValue val = (WSTimerValue) ihcResourceInteractionService.resourceQuery(55555);
        assertEquals(55555, val.getResourceID());
        assertEquals(13851, val.getMilliseconds());
    }

    @Test
    public void testWSWeekdayValueQuery() throws IhcExecption {
        final WSWeekdayValue val = (WSWeekdayValue) ihcResourceInteractionService.resourceQuery(66666);
        assertEquals(66666, val.getResourceID());
        assertEquals(2, val.getWeekdayNumber());
    }

    @Test
    public void testWSDateValueQuery() throws IhcExecption {
        final WSDateValue val = (WSDateValue) ihcResourceInteractionService.resourceQuery(77777);
        assertEquals(77777, val.getResourceID());
        assertEquals(2018, val.getYear());
        assertEquals(10, val.getMonth());
        assertEquals(22, val.getDay());
    }

    @Test
    public void testWSTimeValueQuery() throws IhcExecption {
        final WSTimeValue val = (WSTimeValue) ihcResourceInteractionService.resourceQuery(88888);
        assertEquals(88888, val.getResourceID());
        assertEquals(16, val.getHours());
        assertEquals(32, val.getMinutes());
        assertEquals(45, val.getSeconds());
    }

    @Test
    public void testWSBooleanValueUpdate() throws IhcExecption {
        boolean result = ihcResourceInteractionService.resourceUpdate(new WSBooleanValue(100001, true));
        assertTrue(result);
    }

    @Test
    public void testWSBooleanValueUpdateFailure() throws IhcExecption {
        boolean result = ihcResourceInteractionService.resourceUpdate(new WSBooleanValue(100011, true));
        assertFalse(result);
    }

    @Test
    public void testWSFloatingPointValueUpdate() throws IhcExecption {
        boolean result = ihcResourceInteractionService
                .resourceUpdate(new WSFloatingPointValue(200002, 24.1, -1000.0, 1000.0));
        assertTrue(result);
    }

    @Test
    public void testWSEnumValueUpdate() throws IhcExecption {
        boolean result = ihcResourceInteractionService.resourceUpdate(new WSEnumValue(300003, 11111, 22222, "test123"));
        assertTrue(result);
    }

    @Test
    public void testWSIntegerValueUpdate() throws IhcExecption {
        boolean result = ihcResourceInteractionService.resourceUpdate(new WSIntegerValue(400004, 201, -1000, 1000));
        assertTrue(result);
    }

    @Test
    public void testWSTimerValueUpdate() throws IhcExecption {
        boolean result = ihcResourceInteractionService.resourceUpdate(new WSTimerValue(500005, 2134));
        assertTrue(result);
    }

    @Test
    public void testWSWeekdayValueUpdate() throws IhcExecption {
        boolean result = ihcResourceInteractionService.resourceUpdate(new WSWeekdayValue(600006, 4));
        assertTrue(result);
    }

    @Test
    public void testWSDateValueUpdate() throws IhcExecption {
        boolean result = ihcResourceInteractionService
                .resourceUpdate(new WSDateValue(700007, (short) 2018, (byte) 3, (byte) 24));
        assertTrue(result);
    }

    @Test
    public void testWSTimeValueUpdate() throws IhcExecption {
        boolean result = ihcResourceInteractionService.resourceUpdate(new WSTimeValue(800008, 15, 34, 45));
        assertTrue(result);
    }

    @Test
    public void testResourceValueNotifications() throws IhcExecption, SocketTimeoutException {
        final List<WSResourceValue> list = ihcResourceInteractionService.waitResourceValueNotifications(1);
        assertEquals(8, list.size());

        List<WSResourceValue> found = new ArrayList<WSResourceValue>();

        for (WSResourceValue val : list) {
            switch (val.getResourceID()) {
                case 10454030:
                    assertEquals(2018, ((WSDateValue) val).getYear());
                    assertEquals(9, ((WSDateValue) val).getMonth());
                    assertEquals(28, ((WSDateValue) val).getDay());
                    found.add(val);
                    break;
                case 10454541:
                    assertEquals(10, ((WSTimeValue) val).getHours());
                    assertEquals(20, ((WSTimeValue) val).getMinutes());
                    assertEquals(30, ((WSTimeValue) val).getSeconds());
                    found.add(val);
                    break;
                case 10447883:
                    assertEquals(456789, ((WSIntegerValue) val).getInteger());
                    assertEquals(-2147483648, ((WSIntegerValue) val).getMinimumValue());
                    assertEquals(2147483647, ((WSIntegerValue) val).getMaximumValue());
                    found.add(val);
                    break;
                case 4133210:
                    assertEquals(false, ((WSBooleanValue) val).booleanValue());
                    found.add(val);
                    break;
                case 3988827:
                    assertEquals(true, ((WSBooleanValue) val).booleanValue());
                    found.add(val);
                    break;
                case 4159252:
                    assertEquals(24.50, ((WSFloatingPointValue) val).getFloatingPointValue(), 0.01);
                    assertEquals(-1000.00, ((WSFloatingPointValue) val).getMinimumValue(), 0.01);
                    assertEquals(1000.00, ((WSFloatingPointValue) val).getMaximumValue(), 0.01);
                    found.add(val);
                    break;
                case 3515401:
                    assertEquals(2, ((WSWeekdayValue) val).getWeekdayNumber());
                    found.add(val);
                    break;
                case 7419663:
                    assertEquals(4236359, ((WSEnumValue) val).getDefinitionTypeID());
                    assertEquals(4236872, ((WSEnumValue) val).getEnumValueID());
                    assertEquals("testVal", ((WSEnumValue) val).getEnumName());
                    found.add(val);
                    break;
            }
        }
        assertEquals(8, found.size());
    }
}
