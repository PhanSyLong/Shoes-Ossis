package vn.sourcecode.controller.backend;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.sourcecode.controller.BaseController;
import vn.sourcecode.dto.JwConstants;
import vn.sourcecode.dto.SearchModel;
import vn.sourcecode.model.SaleOrder;
import vn.sourcecode.service.SaleOrderService;

@Controller
public class AdminSaleOrderController extends BaseController implements JwConstants {
	@Autowired
	private SaleOrderService saleOrderService;
	
	@RequestMapping(value = "/admin/order-list", method = RequestMethod.GET)
	public String ordertList(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
		
		int status = 2;
		
		if(!StringUtils.isEmpty(request.getParameter("status"))) {//Co chon active or inactive
			status = Integer.parseInt(request.getParameter("status"));
		}
		String beginDate = null;
		String endDate = null;
		if(!StringUtils.isEmpty(request.getParameter("beginDate")) &&
				!StringUtils.isEmpty(request.getParameter("endDate"))) {
			
			beginDate = request.getParameter("beginDate");
			endDate = request.getParameter("endDate");
		}
		SearchModel saleOrderSearch= new SearchModel();
		saleOrderSearch.setStatus(status);
		saleOrderSearch.setKeyword(request.getParameter("keyword"));
		saleOrderSearch.setBeginDate(beginDate);
		saleOrderSearch.setEndDate(endDate);
		
		//Phan trang
		
		
		//Het phan trang
		List<SaleOrder> saleOrders = saleOrderService.findAll(); 
		
//		List<SaleOrder> saleOrder = saleOrderService.search(saleOrderSearch);
		BigDecimal totalSales = BigDecimal.ZERO;
		for(SaleOrder saleOrder : saleOrders) {
				totalSales = totalSales.add(saleOrder.getTotal());
		}
		
		model.addAttribute("saleOrders", saleOrders);
		model.addAttribute("totalSales", totalSales);
		model.addAttribute("saleOrderSearch", saleOrderSearch);
		return "backend/order-list";
	}
}
