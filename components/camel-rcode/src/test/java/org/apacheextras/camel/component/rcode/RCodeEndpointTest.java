/**************************************************************************************
 https://camel-extra.github.io

 This program is free software; you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public License
 as published by the Free Software Foundation; either version 3
 of the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Lesser General Public License for more details.


 You should have received a copy of the GNU Lesser General Public
 License along with this program; if not, write to the Free Software
 Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 02110-1301, USA.

 http://www.gnu.org/licenses/lgpl-3.0-standalone.html
 ***************************************************************************************/
package org.apacheextras.camel.component.rcode;

import static org.junit.Assert.assertNotNull;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.junit.Test;

public class RCodeEndpointTest {

    @Test(expected = UnsupportedOperationException.class)
    public void testEmptyConstructor() throws Exception {
        RCodeEndpoint endpoint = new RCodeEndpoint();
        assertNotNull(endpoint);

        endpoint.createConsumer(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                // Nothing to do
            }
        });
    }

    @Test(expected = NullPointerException.class)
    public void testUriComponentConstructor() {
        RCodeComponent component = new RCodeComponent();
        RCodeEndpoint endpoint = new RCodeEndpoint("rcode://tmp", component);
        assertNotNull(endpoint);

        endpoint.reconnect();
    }
}
