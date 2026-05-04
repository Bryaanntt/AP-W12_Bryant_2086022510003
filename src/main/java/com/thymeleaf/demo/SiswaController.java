package com.thymeleaf.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/siswa")
public class SiswaController {

    @Autowired
    private SiswaRepository siswaRepository;

    // READ 
    @GetMapping
    public String getAllSiswa(Model model) {
        model.addAttribute("siswaList", siswaRepository.findAll());
        return "siswa";
    }

    // API JSON - untuk hadir.html fetch
    @GetMapping(path = "/all", produces = "application/json")
    @ResponseBody
    public Iterable<Siswa> getAllJson() {
        return siswaRepository.findAll();
    }

    // CREATE
    @GetMapping("/create")
    public String tambahSiswa(
            @RequestParam String nama,
            @RequestParam String nim,
            @RequestParam String kelas,
            @RequestParam String matakuliah,
            @RequestParam(defaultValue = "false") boolean hadir) {

        Siswa o = new Siswa();
        o.setNama(nama);
        o.setNim(nim);
        o.setKelas(kelas);
        o.setMatakuliah(matakuliah);
        o.setHadir(hadir);
        siswaRepository.save(o);
        return "redirect:/siswa";
    }

    // UPDATE
    @GetMapping("/update/{id}")
    public String editSiswa(
            @PathVariable int id,
            @RequestParam String nama,
            @RequestParam String nim,
            @RequestParam String kelas,
            @RequestParam String matakuliah,
            @RequestParam(defaultValue = "false") boolean hadir) {

        Siswa o = siswaRepository.findById(id).orElse(null);
        if (o == null) return "redirect:/siswa";
        o.setNama(nama);
        o.setNim(nim);
        o.setKelas(kelas);
        o.setMatakuliah(matakuliah);
        o.setHadir(hadir);
        siswaRepository.save(o);
        return "redirect:/siswa";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String deleteSiswa(@PathVariable int id) {
        siswaRepository.deleteById(id);
        return "redirect:/siswa";
    }

    // Halaman absensi
    @GetMapping("/hadir")
    public String halamanHadir() {
        return "hadir";
    }
}