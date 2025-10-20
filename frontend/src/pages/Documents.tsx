import { useEffect, useState } from 'react'
import api from '../api'

export default function Documents(){
  const [projectId, setProjectId] = useState('')
  const [list, setList] = useState<any[]>([])
  const load = async () => {
    if (!projectId) return
    const { data } = await api.get(`/api/projects/${projectId}/documents`)
    setList(data)
  }
  return (
    <div>
      <h3>Documents</h3>
      <div className="mb-3">
        <input placeholder="Project ID..." className="form-control" value={projectId} onChange={e=>setProjectId(e.target.value)} />
      </div>
      <button className="btn btn-primary mb-3" onClick={load}>Load</button>
      <ul className="list-group">
        {list.map(d => <li key={d.id} className="list-group-item">
          <div className="fw-bold">{d.title}</div>
          <div className="text-muted">{d.description}</div>
          <a href={d.urlOrPath} target="_blank">Open</a>
        </li>)}
      </ul>
    </div>
  )
}
