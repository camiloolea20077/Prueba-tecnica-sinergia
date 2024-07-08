import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { EnvioMaritimo } from '../models/envioMaritimo';

@Injectable({
  providedIn: 'root'
})
export class MaritimoService {
  private apiUrl = 'http://localhost:8080/envios-maritimos';

  constructor(private http: HttpClient) {}

  getEnvios(): Observable<EnvioMaritimo[]> {
    return this.http.get<EnvioMaritimo[]>(this.apiUrl);
  }

  getEnvio(id: number): Observable<EnvioMaritimo> {
    return this.http.get<EnvioMaritimo>(`${this.apiUrl}/${id}`);
  }

  addEnvio(envio: EnvioMaritimo): Observable<EnvioMaritimo> {
    return this.http.post<EnvioMaritimo>(this.apiUrl, envio);
  }

  deleteEnvio(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}