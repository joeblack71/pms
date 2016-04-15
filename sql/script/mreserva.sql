
CREATE TABLE [MRESERVA] (
	[tCodigoReserva] [nvarchar] (6) COLLATE Modern_Spanish_CI_AS NOT NULL ,
	[tHotel] [nvarchar] (2) COLLATE Modern_Spanish_CI_AS NULL ,
	[tCodigoCompania] [nvarchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[tCodigoReferencia] [nvarchar] (5) COLLATE Modern_Spanish_CI_AS NULL ,
	[tGrupo] [nvarchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[nPasajero] [smallint] NULL CONSTRAINT [DF__MRESERVA__nPasaj__123EB7A3] DEFAULT (0),
	[nPasajeroN] [smallint] NULL CONSTRAINT [DF_MRESERVA_nPasajeroN] DEFAULT (0),
	[nPasajeroLiberado] [nvarchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[fLlegada] [datetime] NULL CONSTRAINT [DF_MRESERVA_fLlegada] DEFAULT (''),
	[hLlegada] [datetime] NULL ,
	[fSalida] [datetime] NULL CONSTRAINT [DF_MRESERVA_fSalida] DEFAULT (''),
	[hSalida] [datetime] NULL ,
	[lIncluido] [bit] NOT NULL CONSTRAINT [DF__MRESERVA__lInclu__1332DBDC] DEFAULT (0),
	[tEstadoReserva] [nvarchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[tFormaReserva] [nvarchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[nTotalReserva] [float] NULL ,
	[lWalking] [bit] NOT NULL CONSTRAINT [DF__MRESERVA__lWalki__14270015] DEFAULT (0),
	[fRecepcion] [datetime] NULL ,
	[hRecepcion] [datetime] NULL ,
	[tUsuarioRecepcion] [nvarchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[fCreacion] [datetime] NULL ,
	[hCreacion] [datetime] NULL ,
	[tUsuarioCreacion] [nvarchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[tCodigoTarifa] [nvarchar] (3) COLLATE Modern_Spanish_CI_AS NULL ,
	[tCodigoContacto] [nvarchar] (4) COLLATE Modern_Spanish_CI_AS NULL ,
	[mObservacion] [nvarchar] (600) COLLATE Modern_Spanish_CI_AS NULL CONSTRAINT [DF_MRESERVA_mObservacion] DEFAULT (''),
	[tCodigoReservaMadre] [nvarchar] (6) COLLATE Modern_Spanish_CI_AS NULL ,
	[tTipoReserva] [nvarchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[tTipoTarifa] [nvarchar] (1) COLLATE Modern_Spanish_CI_AS NULL ,
	[tConfirmacion] [varchar] (50) COLLATE Modern_Spanish_CI_AS NULL ,
	[fConfirmacion] [datetime] NULL ,
	[mObservacionAnulacion] [varchar] (600) COLLATE Modern_Spanish_CI_AS NULL ,
	[tUsuarioAnulacion] [nvarchar] (15) COLLATE Modern_Spanish_CI_AS NULL ,
	[fAnulacion] [datetime] NULL ,
	[hAnulacion] [datetime] NULL ,
	[mObservacionExt] [nvarchar] (600) COLLATE Modern_Spanish_CI_AS NULL ,
	[lReplica] [bit] NOT NULL CONSTRAINT [DF__MRESERVA__lRepli__19120B7B] DEFAULT (0),
	[tUsuarioModifica] [char] (3) COLLATE Modern_Spanish_CI_AS NOT NULL CONSTRAINT [DF__MRESERVA__tUsuar__5466768F] DEFAULT (''),
	[nPasajeroI] [smallint] NOT NULL CONSTRAINT [DF__mreserva__nPasaj__3E99C4D0] DEFAULT (0),
	[tclasereserva] [nvarchar] (1) COLLATE Modern_Spanish_CI_AS NOT NULL CONSTRAINT [DF__mReserva__tclase__4BF3BFEE] DEFAULT (''),
	[Lreingreso] [bit] NOT NULL CONSTRAINT [DF_MRESERVA_Lreingreso] DEFAULT (0),
	CONSTRAINT [aaaaaMRESERVA_PK] PRIMARY KEY  NONCLUSTERED 
	(
		[tCodigoReserva]
	)  ON [PRIMARY] 
) ON [PRIMARY]
GO


