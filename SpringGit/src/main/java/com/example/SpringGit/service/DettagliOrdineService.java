package com.example.SpringGit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.SpringGit.entity.Articolo;
import com.example.SpringGit.entity.DettaglioOrdine;
import com.example.SpringGit.entity.Ordine;
import com.example.SpringGit.repository.ArticoliRepository;
import com.example.SpringGit.repository.DettagliOrdineRepository;
import com.example.SpringGit.repository.OrdineRepository;

@Service
public class DettagliOrdineService {

	@Autowired
	private DettagliOrdineRepository dettagliOrdineRepository;
	@Autowired
	private ArticoliRepository articoliRepository;
	@Autowired
	private OrdineRepository ordiniRepository;

	@Transactional
	public void add(String ordine,int articolo,int qta) throws Exception {
		Optional<Articolo> oa = articoliRepository.findById(articolo);
		if (!oa.isPresent())
			throw new Exception("KO - Articolo non presente");
		DettaglioOrdine d = new DettaglioOrdine();
		trovaOrdine(d, ordine);
		d.setArticolo(oa.get());
		d.setPrezzo(oa.get().getPrezzo());
		d.setQta(qta);
		d.setIva(oa.get().getIva());

		dettagliOrdineRepository.save(d);

	}

	@Transactional
	public void modify(int dettaglioOrdine, int articolo, String ordine, double prezzo, double iva, int qta) throws Exception {
		Optional<DettaglioOrdine> od = dettagliOrdineRepository.findById(dettaglioOrdine);
		if (!od.isPresent())
			throw new Exception("KO - Dettaglio Ordine non presente");
		DettaglioOrdine d = od.get();
		if (articolo > 0) {
			Optional<Articolo> oa = articoliRepository.findById(articolo);
			if (!oa.isPresent())
				throw new Exception("KO - Articolo non presente");
			d.setArticolo(oa.get());
		}
		trovaOrdine(d, ordine);
		if (prezzo > 0)
			d.setPrezzo(prezzo);
		if (iva > 0)
			d.setIva(iva);
		if (qta > 0)
			d.setQta(qta);
	}

	@Transactional
	public void delete(int dettaglioOrdine) throws Exception {
		Optional<DettaglioOrdine> od = dettagliOrdineRepository.findById(dettaglioOrdine);
		if (!od.isPresent())
			throw new Exception("KO - Dettaglio Ordine non presente");
		dettagliOrdineRepository.delete(od.get());
	}

	public List<DettaglioOrdine> showByOrdine(int ordine) throws Exception {
		Optional<Ordine> oo = ordiniRepository.findById(ordine);
		if (!oo.isPresent())
			throw new Exception("KO - Ordine non presente");
		return dettagliOrdineRepository.findByOrdine(oo.get());
	}

	public List<DettaglioOrdine> showByArticolo(int articolo) throws Exception{
		Optional<Articolo> oa=articoliRepository.findById(articolo);
		if(!oa.isPresent())
			throw new Exception("KO - Articolo non presente");
		return dettagliOrdineRepository.findByArticolo(oa.get());
	}

	public DettaglioOrdine showById(int dettaglioOrdine) throws Exception {
		Optional<DettaglioOrdine> od=dettagliOrdineRepository.findById(dettaglioOrdine);
		if(!od.isPresent())
			throw new Exception("KO - Dettaglio Ordine non presente");
		return od.get();
	}

	private void trovaOrdine(DettaglioOrdine d, String ordine) throws Exception {
		int id;
		Optional<Ordine> oo;
		try {
			id = Integer.parseInt(ordine);
			if (id < 0)
				return;
			oo = ordiniRepository.findById(id);
			if (!oo.isPresent())
				throw new Exception("KO - Ordine non presente");
		} catch (NumberFormatException nfe) {
			oo = ordiniRepository.findByNumOrdine(ordine);
			if (!oo.isPresent())
				throw new Exception("KO - Ordine non presente");
		}
		d.setOrdine(oo.get());
	}

}
