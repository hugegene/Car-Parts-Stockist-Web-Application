package nus.iss.sa45.team13.stockist.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import nus.iss.sa45.team13.stockist.model.Suppliers;
import nus.iss.sa45.team13.stockist.repository.SuppliersRepository;

@Service
public class SuppliersServiceImpl implements SuppliersService {
	
	@Resource
	SuppliersRepository suprepos;
	
	/* (non-Javadoc)
	 * @see nus.iss.sa45.team13.stockist.services.SuppliersService#findAllSuppliers()
	 */
	@Override
	@Transactional
	public ArrayList<Suppliers> findAllSuppliers()
	{
		return (ArrayList<Suppliers>) suprepos.findAll();
	}
	
	/* (non-Javadoc)
	 * @see nus.iss.sa45.team13.stockist.services.SuppliersService#findOneSupplier(int)
	 */
	@Override
	@Transactional
	public Suppliers findOneSupplier(int supid)
	{
		return suprepos.findOne(supid);
	}
	
	/* (non-Javadoc)
	 * @see nus.iss.sa45.team13.stockist.services.SuppliersService#createSupplier(nus.iss.sa45.team13.stockist.model.Suppliers)
	 */
	@Override
	@Transactional
	public Suppliers createSupplier(Suppliers s)
	{
		return suprepos.save(s);
	}
	
	/* (non-Javadoc)
	 * @see nus.iss.sa45.team13.stockist.services.SuppliersService#updateSupplier(nus.iss.sa45.team13.stockist.model.Suppliers)
	 */
	@Override
	@Transactional
	public Suppliers updateSupplier(Suppliers s)
	{
		return suprepos.save(s);
	}
	
	/* (non-Javadoc)
	 * @see nus.iss.sa45.team13.stockist.services.SuppliersService#deleteSupplier(nus.iss.sa45.team13.stockist.model.Suppliers)
	 */
	@Override
	@Transactional
	public void deleteSupplier(Suppliers s)
	{
			suprepos.delete(s);
	}
	
	

}
