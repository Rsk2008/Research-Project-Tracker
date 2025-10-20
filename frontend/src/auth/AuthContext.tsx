import React, { createContext, useContext, useEffect, useState } from 'react'
import jwtDecode from 'jwt-decode'

type AuthContextT = {
  token: string | null
  role: string | null
  login: (t: string) => void
  logout: () => void
}

const AuthContext = createContext<AuthContextT>({
  token: null, role: null, login: () => {}, logout: () => {}
})

export const AuthProvider: React.FC<{children: React.ReactNode}> = ({ children }) => {
  const [token, setToken] = useState<string | null>(() => localStorage.getItem('token'))
  const [role, setRole] = useState<string | null>(() => localStorage.getItem('role'))

  const login = (t: string) => {
    setToken(t)
    localStorage.setItem('token', t)
    try {
      const decoded: any = jwtDecode(t)
      const r = decoded?.role ?? null
      setRole(r)
      if (r) localStorage.setItem('role', r)
    } catch { /* ignore */ }
  }

  const logout = () => {
    setToken(null); setRole(null)
    localStorage.removeItem('token'); localStorage.removeItem('role')
  }

  useEffect(() => {
    // naive token expiry handling: if decode fails, force logout on requests
  }, [])

  return <AuthContext.Provider value={{ token, role, login, logout }}>{children}</AuthContext.Provider>
}

export const useAuth = () => useContext(AuthContext)
