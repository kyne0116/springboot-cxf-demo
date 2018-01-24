/**
 * 版权所有 © 北京晟壁科技有限公司 2008-2027。保留一切权利!
 */
package com.simbest.ws.server;

import com.simbest.ws.humansrv.GetCustomersInput;
import com.simbest.ws.humansrv.GetCustomersOutput;
import com.simbest.ws.humansrv.GetManagerInput;
import com.simbest.ws.humansrv.GetManagerOutput;
import com.simbest.ws.humansrv.GetPeopleAgeInput;
import com.simbest.ws.humansrv.GetPeopleAgeOutput;
import com.simbest.ws.humansrv.HumanSrvService;
import com.simbest.ws.humansrv.NoSuchPersonException;

/**
 * @author lishuyi
 */
public class HumanSrvServiceImpl implements HumanSrvService {

    @Override
    public GetCustomersOutput getCustomers(GetCustomersInput gender) throws NoSuchPersonException {
        GetCustomersOutput output = new GetCustomersOutput();
        return output;
    }

    @Override
    public GetPeopleAgeOutput getPeopleAge(GetPeopleAgeInput person) {
        GetPeopleAgeOutput output = new GetPeopleAgeOutput();
        return output;
    }

    @Override
    public GetManagerOutput getManager(GetManagerInput employee) throws NoSuchPersonException {
        GetManagerOutput output = new GetManagerOutput();
        return output;
    }
}
